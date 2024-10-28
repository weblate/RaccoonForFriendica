package com.livefast.eattrash.raccoonforfriendica.core.htmlparse

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.mohamedrejeb.ksoup.entities.KsoupEntities
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlHandler
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlParser

fun String.parseHtml(
    linkColor: Color,
    requiresHtmlDecode: Boolean = true,
): AnnotatedString {
    val builder = AnnotatedString.Builder()
    var inOrderedList = false
    var orderedListIndex = 0
    val handler =
        KsoupHtmlHandler
            .Builder()
            .onOpenTag { name, attributes, _ ->
                when (name) {
                    "p" ->
                        if (builder.length != 0) {
                            // separate paragraphs with a blank line
                            builder.appendLineIfNeeded()
                            builder.appendLine()
                        }

                    "span" -> Unit
                    "br" -> builder.appendLine()
                    "a" -> {
                        builder.pushStringAnnotation("link", attributes["href"] ?: "")
                        builder.pushStyle(
                            SpanStyle(
                                color = linkColor,
                                textDecoration = TextDecoration.Underline,
                            ),
                        )
                    }

                    "b", "strong" -> builder.pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                    "u" -> builder.pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                    "i", "em" -> builder.pushStyle(SpanStyle(fontStyle = FontStyle.Italic))
                    "s" -> builder.pushStyle(SpanStyle(textDecoration = TextDecoration.LineThrough))
                    "ul" -> builder.appendLineIfNeeded()
                    "ol" -> {
                        builder.appendLineIfNeeded()
                        inOrderedList = true
                    }

                    "li" ->
                        if (inOrderedList) {
                            orderedListIndex++
                            builder.append(" $orderedListIndex. ")
                        } else {
                            builder.append(" • ")
                        }
                    "code" -> builder.pushStyle(SpanStyle(fontFamily = FontFamily.Monospace))
                    "img" -> {
                        val url = attributes["src"]
                        val alt = attributes["alt"]
                        builder.appendLine()
                        builder.append("<img src=\"$url\"")
                        if (!alt.isNullOrBlank()) {
                            builder.append(" alt=\"$alt\"")
                        }
                        builder.append(" />")
                        builder.appendLine()
                    }
                    else -> println("onOpenTag: Unhandled tag $name")
                }
            }.onCloseTag { name, _ ->
                when (name) {
                    "p", "span", "br", "img" -> Unit
                    "b", "strong", "u", "i", "em", "s", "code" -> builder.pop()
                    "a" -> {
                        builder.pop() // corresponds to pushStyle
                        builder.pop() // corresponds to pushStringAnnotation
                    }
                    "ul" -> Unit
                    "ol" -> {
                        orderedListIndex = 0
                        inOrderedList = false
                    }
                    "li" -> builder.appendLine()
                    else -> println("onCloseTag: Unhandled tag $name")
                }
            }.onText { text ->
                builder.append(text)
            }.build()

    val ksoupHtmlParser = KsoupHtmlParser(handler)
    val html = sanitize(requiresHtmlDecode)
    ksoupHtmlParser.write(html)
    ksoupHtmlParser.end()

    return builder.toAnnotatedString()
}

private fun AnnotatedString.Builder.appendLineIfNeeded() {
    val lastChar = toAnnotatedString().lastOrNull()
    if (lastChar != null && lastChar != '\n') {
        appendLine()
    }
}

private fun String.sanitize(requiresHtmlDecode: Boolean): String =
    run {
        if (requiresHtmlDecode) {
            KsoupEntities.decodeHtml(this)
        } else {
            this
        }
    }.replace("<p><br></p>", "<br/>")
