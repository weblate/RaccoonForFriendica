package com.livefast.eattrash.raccoonforfriendica.core.l10n.messages

internal val ItStrings =
    object : DefaultStrings() {
        override val messageConfirmExit = "Premi di nuovo 🔙 per uscire"
        override val messageAreYouSure = "Sei sicuro/a di voler continuare"
        override val messageSuccess = "Operazione completata con successo!"
        override val messageGenericError = "Si è verificato un errore inaspettato"
        override val messageInvalidField = "Campo non valido"
        override val messageMissingField = "Campo obbligatorio"
        override val messageEmptyList = "Qui non c'è nulla da visualizzare 🗑️"
        override val buttonConfirm = "Conferma"
        override val buttonOk = "OK"
        override val buttonClose = "Chiudi"
        override val buttonCancel = "Annulla"
        override val systemDefault = "Sistema"
        override val settingsThemeLight = "Chiaro"
        override val settingsThemeDark = "Scuro"
        override val settingsThemeBlack = "Nero (AMOLED)"
        override val sectionTitleHome = "Timeline"
        override val sectionTitleExplore = "Esplora"
        override val sectionTitleInbox = "Inbox"
        override val sectionTitleProfile = "Profilo"
        override val barThemeOpaque = "Opaco"
        override val barThemeTransparent = "Trasparente"
        override val timelineAll = "Tutti"
        override val timelineSubscriptions = "Iscrizioni"
        override val timelineLocal = "Locale"
        override val nodeVia = "via"
        override val timelineEntryInReplyTo = "in risposta a"
        override val timelineEntryRebloggedBy = "ricondiviso da"

        override fun accountFollower(count: Int) =
            when (count) {
                1 -> "seguace"
                else -> "seguaci"
            }

        override fun accountFollowing(count: Int) =
            when (count) {
                1 -> "seguito"
                else -> "seguiti"
            }

        override val accountAge = "età account"
        override val dateYearShort = "a"
        override val dateMonthShort = "m"
        override val dateDayShort = "g"
        override val timeHourShort = "h"
        override val timeMinuteShort = "min"
        override val timeSecondShort = "s"
        override val accountSectionPosts = "Post"
        override val accountSectionAll = "Post & risposte"
        override val accountSectionPinned = "Fissati"
        override val accountSectionMedia = "Media"
        override val postTitle = "Post"
        override val settingsTitle = "Impostazioni"
        override val settingsHeaderGeneral = "Generali"
        override val settingsItemLanguage = "Lingua"
        override val settingsHeaderLookAndFeel = "Aspetto"
        override val settingsItemTheme = "Tema UI"
        override val settingsItemFontFamily = "Tipo di carattere"
        override val settingsItemDynamicColors = "Material You"
        override val settingsItemDynamicColorsSubtitle =
            "genera palette in base al colore dello sfondo"
        override val settingsItemThemeColor = "Colore tema"
        override val settingsItemThemeColorSubtitle =
            "applicato solo se \"Material You\" è disabilitato"
        override val themeColorPurple = "Piovra portentosa"
        override val themeColorBlue = "Balena ballerina"
        override val themeColorLightBlue = "Delfino distratto"
        override val themeColorGreen = "Rana rilassata"
        override val themeColorYellow = "Riccio rampante"
        override val themeColorOrange = "Volpe virtuosa"
        override val themeColorRed = "Granchio galante"
        override val themeColorPink = "Unicorno unico"
        override val themeColorGray = "Procione pasticcione"
        override val themeColorWhite = "Orso originale"
        override val messageUserUnlogged = "È necessario effettuare il login per poter accedere a questa sezione 🪵"
        override val loginTitle = "Login"
        override val fieldNodeName = "Nome istanza"
        override val fieldUsername = "Username"
        override val fieldPassword = "Password"
        override val actionLogout = "Logout"
        override val relationshipStatusFollowing = "Segui già"
        override val relationshipStatusFollowsYou = "Ti segue"
        override val relationshipStatusMutual = "Reciproci"
        override val relationshipStatusRequestedToOther = "Richiesta inviata"
        override val relationshipStatusRequestedToYou = "Richiesta in attesa"
        override val notificationTypeEntry = "ha pubblicato un post"
        override val notificationTypeFavorite = "ha aggiunto il tuo post ai preferiti"
        override val notificationTypeFollow = "ha iniziato a seguirti"
        override val notificationTypeFollowRequest = "ha inviato la richiesta di seguirti"
        override val notificationTypeReply = "ti ha risposto"
        override val notificationTypePoll = "un sondaggio cui hai partecipato si è chiuso"
        override val notificationTypeReblog = "ha ricondiviso il tuo post"
        override val notificationTypeUpdate = "ha aggiornato un post che hai ricondiviso"
        override val exploreSectionHashtags = "Hashtag"
        override val exploreSectionLinks = "Link"
        override val exploreSectionSuggestions = "Per te"

        override fun hashtagPeopleUsing(count: Int) =
            when (count) {
                1 -> "persona ne sta parlando"
                else -> "persone ne stanno parlando"
            }

        override val feedTypeTitle = "Tipo di feed"
        override val followerTitle = "Seguaci"
        override val followingTitle = "Seguiti"
        override val actionFollow = "Segui"
        override val actionUnfollow = "Non seguire più"
        override val actionDeleteFollowRequest = "Annulla richiesta di seguire"
        override val sidebarAnonymousTitle = "Anonimo"
        override val sidebarAnonymousMessage =
            "Benvenuto/a su Raccoon!\n\nPuoi effettuare il login sulla tua istanza in qualsiasi momento dalla schermata Profilo.\n\nDivertiti su Friendica!"
        override val bookmarksTitle = "Segnalibri"
        override val favoritesTitle = "Preferiti"
        override val followedHashtagsTitle = "Hashtag che segui"
        override val infoEdited = "modificato"

        override fun extendedSocialInfoFavorites(count: Int) =
            when (count) {
                1 -> "preferito"
                else -> "preferiti"
            }

        override fun extendedSocialInfoReblogs(count: Int) =
            when (count) {
                1 -> "ricondivisione"
                else -> "ricondivisioni"
            }

        override val actionMuteNotifications = "Silenzia notifiche"
        override val createPostTitle = "Nuovo post"
        override val messagePostEmptyText = "Inserire almeno un allegato, del testo o un sondaggio"
        override val visibilityPublic = "Pubblico"
        override val visibilityUnlisted = "Non in lista"
        override val visibilityPrivate = "Privato (Friendica)"
        override val visibilityDirect = "Solo menzioni"
        override val createPostBodyPlaceholder = "Un magnifico nuovo post… 🪄"
        override val createPostAttachmentsSection = "Allegati"
        override val actionEdit = "Modifica"
        override val pictureDescriptionPlaceholder = "Descrizione immagine"
        override val insertLinkDialogTitle = "Inserisci link"
        override val insertLinkFieldAnchor = "Ancora"
        override val insertLinkFieldUrl = "URL"
        override val selectUserDialogTitle = "Seleziona utente"
        override val selectUserSearchPlaceholder = "nome utente or identificativo"
        override val searchSectionUsers = "Utenti"
        override val searchPlaceholder = "Cerca nel Fediverso"
        override val messageSearchInitialEmpty = "Inizia a digitare qualcosa"
        override val topicTitle = "Argomento"
        override val threadTitle = "Conversazione"
        override val buttonLoadMoreReplies = "Carica altre risposte"
        override val postSensitive = "Contenuto sensibile"
        override val actionCreateThreadInGroup = "Posta in"
        override val settingsHeaderNsfw = "NSFW"
        override val settingsItemIncludeNsfw = "Includi contenuti NSFW"
        override val settingsItemBlurNsfw = "Offusca media NSFW"
        override val settingsItemDefaultTimelineType = "Tipo di feed predefinito"
        override val actionDelete = "Elimina"
        override val actionShare = "Condividi"
        override val actionCopyUrl = "Copia link"
        override val messageTextCopiedToClipboard = "Copiato negli appunti! 📋"
        override val contentScaleFit = "Adatta alla dimensione"
        override val contentScaleFillWidth = "Adatta alla larghezza"
        override val contentScaleFillHeight = "Adatta alla altezza"
        override val contentScaleTitle = "Modalità ridimensionamento"
        override val shareAsUrl = "Condividi come URL"
        override val shareAsFile = "Condividi come file"
        override val actionMute = "Silenzia"
        override val actionUnmute = "Riattiva"
        override val settingsItemBlockedAndMuted = "Gestione filtri"
        override val manageBlocksSectionMuted = "Silenziati"
        override val manageBlocksSectionBlocked = "Bloccati"
        override val actionBlock = "Blocca"
        override val actionUnblock = "Sblocca"
        override val messageLoginOAuth = "Login con OAuth2 (consigliato)"
        override val or = "oppure"
        override val messageLoginLegacy = "Login con username e password (legacy)"
        override val actionPin = "Fissa sul profilo"
        override val actionUnpin = "Togli dal profilo"
        override val settingsSectionDebug = "Debug"
        override val settingsAbout = "Informazioni app"
        override val settingsAboutAppVersion = "Versione"
        override val settingsAboutChangelog = "Elenco modifiche"
        override val settingsAboutViewGithub = "Vedi su GitHub"
        override val settingsAboutReportIssue = "Segnala un problema"
        override val settingsAboutViewFriendica = "Vedi su Friendica"
        override val manageCirclesTitle = "Cerchie"
        override val createCircleTitle = "Crea cerchia"
        override val editCircleTitle = "Modifica cerchia"
        override val circleEditFieldName = "Nome"
        override val circleAddUsersDialogTitle = "Seleziona utenti da aggiungere"
        override val visibilityCircle = "Cerchia"
        override val selectCircleDialogTitle = "Seleziona una cerchia"
        override val messagePostInvalidVisibility = "Selezionare un'opzione di visibilità valida"
        override val settingsItemFontScale = "Dimensione font"
        override val fontScaleNormal = "Normale"
        override val fontScaleSmaller = "Più piccolo"
        override val fontScaleSmallest = "Piccolissimo"
        override val fontScaleLarger = "Più grande"
        override val fontScaleLargest = "Grandissimo"
        override val settingsItemUrlOpeningMode = "Modalità apertura URL"
        override val urlOpeningModeExternal = "Browser esterno"
        override val urlOpeningModeCustomTabs = "Schede personalizzate"
        override val dialogErrorTitle = "Ops…"
        override val messagePollVoteErrorBody =
            "Purtroppo sono solo uno sviluppatore mobile e non posso aggiungere metodi mancanti al back-end!\nDai un'occhiata alla segnalazione e metti un 👍 in modo che gli sviluppatori sappiano che può valere la pena di implementarlo."
        override val buttonPollErrorOpenIssue = "Vedi su GitHub"
        override val actionVote = "Vota"
        override val pollExpired = "Chiuso"
        override val shortUnavailable = "N/D"

        override fun pollVote(count: Int): String =
            when (count) {
                1 -> "voto"
                else -> "voti"
            }

        override val pollExpiresIn = "Si chiude tra"
        override val actionHideResults = "Mostra risultati"
        override val actionShowResults = "Nascondi risultati"
        override val inboxConfigureFilterDialogTitle = "Configura filtri"
        override val inboxConfigureFilterDialogSubtitle =
            "Se un valore qualsiasi viene deselezionato, il filtro si applicherà solo agli elementi non letti"
        override val notificationTypeEntryName = "Notifiche post"
        override val notificationTypeFavoriteName = "Preferiti"
        override val notificationTypeFollowName = "Nuovi seguaci"
        override val notificationTypeFollowRequestName = "Richieste di seguirti"
        override val notificationTypeMentionName = "Menzioni & Risposte"
        override val notificationTypePollName = "Sondaggi"
        override val notificationTypeReblogName = "Ricondivisioni"
        override val notificationTypeUpdateName = "Modifiche post"
        override val muteDurationIndefinite = "Indefinita"
        override val selectDurationDialogTitle = "Seleziona durata"
        override val muteDurationItem = "Non vedrai più post da questo utente per"
        override val muteDisableNotificationsItem = "Disabilita notifiche"
        override val actionSendFollowRequest = "Invia richiesta"
        override val postBy = "di"
        override val customOption = "Personalizzato"
        override val colorPickerDialogTitle = "Seleziona un colore"
        override val followRequestsTitle = "Richieste di seguirti"
        override val actionAccept = "Accetta"
        override val actionReject = "Rifiuta"
        override val actionHideContent = "Nascondi contenuto"
        override val messageEmptyInbox =
            "🎉 Sei già al passo! 🎉\n\nVedrai comparire le notifiche in questa pagina non appena ce ne saranno di nuove"
        override val createPostSpoilerPlaceholder = "Testo dello spoiler"
        override val createPostTitlePlaceholder = "Titolo (facoltativo)"
        override val actionSwitchAccount = "Cambia account"
        override val actionDeleteAccount = "Elimina account"
        override val editProfileTitle = "Modifica profilo"
        override val editProfileSectionPersonal = "Dati personali"
        override val editProfileItemDisplayName = "Nome visualizzato"
        override val editProfileItemBio = "Bio"
        override val editProfileSectionFlags = "Visibilità & permessi"
        override val editProfileItemBot = "Sono un bot"
        override val editProfileItemLocked =
            "Richiedi approvazione manuale richieste di essere seguito"
        override val editProfileItemDiscoverable = "Rendimi visibile nelle ricerche"
        override val editProfileItemNoIndex = "Escludi i miei post dalle timeline pubbliche"
        override val unsavedChangesTitle = "Modifiche non salvate"
        override val messageAreYouSureExit = "Sei sicuro/a di voler uscire?"
        override val buttonSave = "Salva"
        override val editProfileSectionFields = "Campi personalizzati  (sperimentale)"
        override val editProfileItemFieldKey = "Chiave"
        override val editProfileItemFieldValue = "Valore"
        override val editProfileSectionImages = "Immagini (sperimentale)"
        override val editProfileItemAvatar = "Avatar"
        override val editProfileItemHeader = "Banner"
        override val nodeInfoTitle = "Informazioni istanza"
        override val nodeInfoSectionRules = "Regole"
        override val nodeInfoSectionContact = "Contatto"
        override val actionAddNew = "Aggiungi nuovo"
        override val directMessagesTitle = "Messaggi diretti"

        override fun messages(count: Int): String =
            when (count) {
                1 -> "messaggio"
                else -> "messaggi"
            }

        override val messageEmptyConversation =
            "Questo è l'inizio della tua epica conversazione con"
        override val followRequiredMessage =
            "È necessario seguire l'altro utente per poter inviare un messaggio diretto!"
        override val galleryTitle = "Galleria"

        override fun items(count: Int): String =
            when (count) {
                1 -> "elemento"
                else -> "elementi"
            }

        override val galleryFieldAlbumName = "Nome album"
        override val messageEmptyAlbum =
            "Sembra che questo album sia ancora vuoto… ✨"
        override val actionMove = "Sposta"
        override val pickFromGalleryDialogTitle = "Seleziona dalla galleria"

        override fun unreadMessages(count: Int): String =
            when (count) {
                1 -> "non letto"
                else -> "non letti"
            }

        override val messageCharacterLimitExceeded =
            "Hai superato il limite massimo consentito di caratteri"
        override val userFieldPersonalNote = "Nota personale"
        override val actionEditPersonalNote = "Modifica nota"
        override val actionCancelEditPersonalNote = "Termina modifica nota"
        override val messageVideoNsfw = "Questo video potrebbe contenere materiale sensibile 🙈"
        override val buttonLoad = "Carica"
        override val messageAreYouSureReblog =
            "Questo post è più vecchio di un mese. Sei sicuro/a di volerlo ricondividere?"
        override val unpublishedTitle = "Non pubblicati"
        override val unpublishedSectionScheduled = "Schedulati"
        override val unpublishedSectionDrafts = "Bozze"
        override val actionSetScheduleDate = "Imposta schedulazione"
        override val actionUpdateScheduleDate = "Modifica schedulazione"
        override val actionPublishDefault = "Pubblica ora"
        override val scheduleDateIndication = "Schedulato per il:"
        override val messageScheduleDateInThePast = "Selezionare una data di schedulazione futura"
        override val actionSaveDraft = "Salva bozza"
        override val settingsItemDefaultPostVisibility = "Visibilità predefinita post"
        override val settingsItemDefaultReplyVisibility = "Visibilità predefinita risposte"
        override val reportCategoryLegal = "Problema legale"
        override val itemOther = "Altro"
        override val reportCategorySpam = "Spam"
        override val reportCategoryViolation = "Violazione regole del server"
        override val messageMissingRules = "Seleziona almeno una regola"
        override val createReportTitleUser = "Segnala"
        override val createReportTitleEntry = "Segnala post di"
        override val createReportItemCategory = "Categoria"
        override val createReportCommentPlaceholder = "Descrivi il problema che hai riscontrato"
        override val createReportItemRules = "Regole violate"

        override fun createReportSelectedRules(count: Int) =
            when (count) {
                1 -> "regola selezionata"
                else -> "regole selezionate"
            }

        override val createReportItemForward = "Inoltra segnalazione"
        override val actionReportUser = "Segnala utente"
        override val actionReportEntry = "Segnala post"
        override val actionViewDetails = "Dettagli"
        override val actionAddImageFromGallery = "Add from gallery"
        override val actionAddPoll = "Add poll"
        override val actionRemovePoll = "Remove poll"
        override val createPostPollSection = "Poll"
        override val createPostPollOptionLabel = "Option"
        override val createPostPollItemMultiple = "Allow multiple choice"
        override val createPostPollItemExpirationDate = "Expiration date"
        override val messageInvalidPollError =
            "Sondaggio non valido, controllare le opzioni e la data di fine"
        override val userFeedbackFieldEmail = "Email o username (opzionale)"
        override val userFeedbackFieldComment = "Feedback"
        override val userFeedbackCommentPlaceholder =
            "Descrivi il problema che hai riscontrato o lascia un feedback 🖋️"
        override val changeNodeDialogTitle = "Cambia istanza"
        override val actionQuote = "Cita"
        override val actionAddTitle = "Aggiungi titolo"
        override val actionRemoveTitle = "Rimuovi titolo"
        override val actionRevealContent = "Rivela contenuto"
        override val settingsItemExcludeRepliesFromTimeline = "Escludi risposte dalla timeline"
        override val insertEmojiTitle = "Inserisci emoji"
        override val messageLoadingUsers = "Caricamento utenti"
        override val actionOpenPreview = "Visualizza anteprima"
        override val actionSwitchToClassicMode = "Passa a modalità classica"
        override val actionSwitchToForumMode = "Passa a modalità forum"
        override val settingsItemOpenGroupsInForumModeByDefault =
            "Apri i gruppi in modalità forum di default"
    }
