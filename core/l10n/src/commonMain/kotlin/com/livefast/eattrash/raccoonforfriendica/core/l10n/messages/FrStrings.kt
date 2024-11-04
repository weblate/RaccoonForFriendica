package com.livefast.eattrash.raccoonforfriendica.core.l10n.messages

internal val FrStrings =
    object : DefaultStrings() {
        override val messageConfirmExit = "Appuyez à nouveau sur 🔙 pour quitter."
        override val messageAreYouSure = "Êtes-vous sûr de vouloir continuer ?"
        override val messageSuccess = "L'opération s'est déroulée avec succès !"
        override val messageGenericError = "Une erreur inattendue s'est produite"
        override val messageInvalidField = "Champ invalide"
        override val messageMissingField = "Champ manquant"
        override val messageEmptyList = "Il n'y a rien à afficher ici 🗑️️"
        override val buttonConfirm = "Confirmer"
        override val buttonOk = "OK"
        override val buttonClose = "Fermer"
        override val buttonCancel = "Annuler"
        override val systemDefault = "Système"
        override val settingsThemeLight = "Clair"
        override val settingsThemeDark = "Noir"
        override val settingsThemeBlack = "Noir (AMOLED)"
        override val sectionTitleHome = "Postes"
        override val sectionTitleExplore = "Explorer"
        override val sectionTitleInbox = "Notifications"
        override val sectionTitleProfile = "Profil"
        override val barThemeOpaque = "Opaque"
        override val barThemeTransparent = "Transparent"
        override val timelineAll = "Tous"
        override val timelineSubscriptions = "Abonnements"
        override val timelineLocal = "Local"
        override val nodeVia = "par"
        override val timelineEntryInReplyTo = "en réponse à"
        override val timelineEntryRebloggedBy = "repartagé par"

        override fun accountFollower(count: Int) =
            when (count) {
                1 -> "suiveur"
                else -> "suiveurs"
            }

        override fun accountFollowing(count: Int) =
            when (count) {
                1 -> "suivi"
                else -> "suivis"
            }

        override val accountAge = "âge du compte"
        override val dateYearShort = "a"
        override val dateMonthShort = "m"
        override val dateDayShort = "j"
        override val timeHourShort = "h"
        override val timeMinuteShort = "min"
        override val timeSecondShort = "s"
        override val accountSectionPosts = "Postes"
        override val accountSectionAll = "Postes et réponses"
        override val accountSectionPinned = "Épinglé"
        override val accountSectionMedia = "Média"
        override val postTitle = "Postes"
        override val settingsTitle = "Paramètres"
        override val settingsHeaderGeneral = "Général"
        override val settingsItemLanguage = "Langue"
        override val settingsHeaderLookAndFeel = "Apparence"
        override val settingsItemTheme = "Thème de l'interface utilisateur"
        override val settingsItemFontFamily = "Famille de polices"
        override val settingsItemDynamicColors = "Material You"
        override val settingsItemDynamicColorsSubtitle =
            "générer une palette en fonction de l'arrière-plan"
        override val settingsItemThemeColor = "Couleur du thème"
        override val settingsItemThemeColorSubtitle =
            "appliqué seulement si «Material You» est désactivé"
        override val themeColorPurple = "Pieuvre pantouflarde"
        override val themeColorBlue = "Baleine balourde"
        override val themeColorLightBlue = "Dauphin distrait"
        override val themeColorGreen = "Grenouille gaffeuse"
        override val themeColorYellow = "Hérisson hilarant"
        override val themeColorOrange = "Renard raisonnable"
        override val themeColorRed = "Crabe croquant"
        override val themeColorPink = "Licorne lunatique"
        override val themeColorGray = "Raton-laveur rapide"
        override val themeColorWhite = "Ours ouaté"
        override val messageUserUnlogged = "Vous devez être connecté pour accéder à cette section 🪵"
        override val buttonLogin = "Connexion"
        override val fieldNodeName = "Nom de l'instance"
        override val fieldUsername = "Nom d'utilisateur"
        override val fieldPassword = "Mot de passe"
        override val actionLogout = "Déconnexion"
        override val relationshipStatusFollowing = "Suivre"
        override val relationshipStatusFollowsYou = "Vous suit"
        override val relationshipStatusMutual = "Mutuelle"
        override val relationshipStatusRequestedToOther = "Demande envoyée"
        override val relationshipStatusRequestedToYou = "Demande en attente"
        override val notificationTypeEntry = "a publié un message"
        override val notificationTypeFavorite = "a ajouté votre message à ses favoris"
        override val notificationTypeFollow = "a commencé à vous suivre"
        override val notificationTypeFollowRequest = "vous a envoyé une demande de suivi"
        override val notificationTypeReply = "vous a répondu"
        override val notificationTypePoll = "un sondage auquel vous avez participé a été clôturé"
        override val notificationTypeReblog = "a repartagé votre message"
        override val notificationTypeUpdate = "mis à jour un message que vous avez repartagé"
        override val exploreSectionHashtags = "Hashtags"
        override val exploreSectionLinks = "Liens"
        override val exploreSectionSuggestions = "Pour vous"

        override fun hashtagPeopleUsing(count: Int) =
            when (count) {
                1 -> "personne en parle"
                else -> "personnes en parlent"
            }

        override val feedTypeTitle = "Type de flux"
        override val followerTitle = "Suiveurs"
        override val followingTitle = "Suivre"
        override val actionFollow = "Suivre"
        override val actionUnfollow = "Ne pas suivre"
        override val actionDeleteFollowRequest = "Annuler la demande de suivi"
        override val sidebarAnonymousTitle = "Anonyme"
        override val sidebarAnonymousMessage =
            "Bienvenu(e)s à Raccoon !\n\nVous pouvez vous connecter à votre instance à tout moment à partir de l'écran Profil.\n\nAmusez-vous bien sur Friendica !"
        override val bookmarksTitle = "Signets"
        override val favoritesTitle = "Favoris"
        override val followedHashtagsTitle = "Hashtags suivis"
        override val infoEdited = "édité"

        override fun extendedSocialInfoFavorites(count: Int) =
            when (count) {
                1 -> "préféré"
                else -> "préférés"
            }

        override fun extendedSocialInfoReblogs(count: Int) =
            when (count) {
                1 -> "repartage"
                else -> "repartage"
            }

        override val actionMuteNotifications = "Désactiver les notifications"
        override val createPostTitle = "Créer un poste"
        override val messagePostEmptyText =
            "Veuillez fournir une pièce jointe, un sondage ou un texte."
        override val visibilityPublic = "Public"
        override val visibilityUnlisted = "Non répertorié"
        override val visibilityPrivate = "Seuls suiveurs"
        override val visibilityDirect = "Seulement mentionnés"
        override val createPostBodyPlaceholder = "Votre nouveau poste génial… 🪄"
        override val createPostAttachmentsSection = "Annexes"
        override val actionEdit = "Éditer"
        override val pictureDescriptionPlaceholder = "Description de l'image"
        override val insertLinkDialogTitle = "Lien d'insertion"
        override val insertLinkFieldAnchor = "Ancrage"
        override val insertLinkFieldUrl = "URL"
        override val selectUserDialogTitle = "Sélectionner un utilisateur"
        override val selectUserSearchPlaceholder = "nom d'utilisateur ou pseudo"
        override val searchSectionUsers = "Utilisateurs"
        override val searchPlaceholder = "Rechercher dans Fediverse"
        override val messageSearchInitialEmpty = "Commencer à taper quelque chose"
        override val topicTitle = "Sujet"
        override val threadTitle = "Conversation"
        override val buttonLoadMoreReplies = "Charger plus de réponses"
        override val postSensitive = "Contenu sensible"
        override val actionCreateThreadInGroup = "Poster à"
        override val settingsHeaderNsfw = "NSFW"
        override val settingsItemIncludeNsfw = "Inclure des contenus NSFW"
        override val settingsItemBlurNsfw = "Flouter les médias NSFW"
        override val settingsItemDefaultTimelineType = "Type de ligne de temps par défaut"
        override val actionDelete = "Supprimer"
        override val actionShare = "Partager"
        override val actionCopyUrl = "Copier le lien"
        override val messageTextCopiedToClipboard = "Copié dans le presse-papiers ! 📋"
        override val contentScaleFit = "Ajustement de l'aspect"
        override val contentScaleFillWidth = "Largeur du remplissage"
        override val contentScaleFillHeight = "Hauteur du remplissage"
        override val contentScaleTitle = "Mode d'échelle"
        override val shareAsUrl = "Partager en tant qu'URL"
        override val shareAsFile = "Partager en tant que fichier"
        override val actionMute = "Couper le son"
        override val actionUnmute = "Rétablir le son"
        override val settingsItemBlockedAndMuted = "Gérer les filtres"
        override val manageBlocksSectionMuted = "En sourdine"
        override val manageBlocksSectionBlocked = "Bloqué"
        override val actionBlock = "Bloquer"
        override val actionUnblock = "Débloquer"
        override val loginMethodBasic = "ancien"
        override val actionPin = "Épingler au profil"
        override val actionUnpin = "Désépingler du profil"
        override val settingsSectionDebug = "Débogage"
        override val settingsAbout = "Informations sur l'application"
        override val settingsAboutAppVersion = "Version"
        override val settingsAboutChangelog = "Changelog"
        override val settingsAboutViewGithub = "Voir sur GitHub"
        override val settingsAboutReportIssue = "Signaler un problème"
        override val settingsAboutViewFriendica = "Voir sur Friendica"
        override val manageCirclesTitle = "Cercles"
        override val createCircleTitle = "Créer un cercle"
        override val editCircleTitle = "Modifier un cercle"
        override val circleEditFieldName = "Nom du cercle"
        override val circleAddUsersDialogTitle = "Sélectionner les utilisateurs à ajouter"
        override val visibilityCircle = "Cercle"
        override val selectCircleDialogTitle = "Sélectionner un cercle"
        override val messagePostInvalidVisibility =
            "Veuillez sélectionner une option de visibilité valide"
        override val settingsItemFontScale = "Taille de la police"
        override val fontScaleNormal = "Normal"
        override val fontScaleSmaller = "Plus petite"
        override val fontScaleSmallest = "Plus petit"
        override val fontScaleLarger = "Plus grand"
        override val fontScaleLargest = "Le plus grand"
        override val settingsItemUrlOpeningMode = "Mode d'ouverture de l'URL"
        override val urlOpeningModeExternal = "Externe"
        override val urlOpeningModeCustomTabs = "Onglets personnalisés"
        override val dialogErrorTitle = "Oups..."
        override val messagePollVoteErrorBody =
            "Malheureusement, je ne suis qu'un développeur mobile et je ne peux pas ajouter les méthodes back-end manquantes !\nJetez un œil à ce problème et mettez un 👍 pour que les développeurs sachent que cela peut valoir la peine de l'implémenter."
        override val buttonPollErrorOpenIssue = "Voir sur GitHu"
        override val actionVote = "Vot"
        override val pollExpired = "Expir"
        override val shortUnavailable = "N/D"

        override fun pollVote(count: Int): String =
            when (count) {
                1 -> "vote"
                else -> "votes"
            }

        override val pollExpiresIn = "Expire en"
        override val actionHideResults = "Afficher les résultats"
        override val actionShowResults = "Cacher les résultats"
        override val inboxConfigureFilterDialogTitle = "Configurer les filtres"
        override val inboxConfigureFilterDialogSubtitle =
            "Si une valeur est désélectionnée, le filtre ne renverra que les éléments non lus."
        override val notificationTypeEntryName = "Notifications de publication"
        override val notificationTypeFavoriteName = "Favoris"
        override val notificationTypeFollowName = "Nouveaux suiveurs"
        override val notificationTypeFollowRequestName = "Demandes de suivi"
        override val notificationTypeMentionName = "Mentions et réponses"
        override val notificationTypePollName = "Sondages"
        override val notificationTypeReblogName = "Repartage"
        override val notificationTypeUpdateName = "Mises à jour des messages"
        override val muteDurationIndefinite = "Durée indéterminée"
        override val selectDurationDialogTitle = "Sélectionnez la durée"
        override val muteDurationItem = "Vous ne verrez pas les messages de cet utilisateur pendant"
        override val muteDisableNotificationsItem = "Désactiver les notifications"
        override val actionSendFollowRequest = "Envoyer une demande"
        override val postBy = "par"
        override val customOption = "Personnalisé"
        override val colorPickerDialogTitle = "Sélectionner une couleur"
        override val followRequestsTitle = "Demandes de suivi"
        override val actionAccept = "Accepter"
        override val actionReject = "Rejeter"
        override val actionHideContent = "Cacher le contenu"
        override val messageEmptyInbox =
            "🎉 Vous êtes au courant ! 🎉\n\nVous verrez les nouvelles notifications dans cette page dès qu'elles arriveront"
        override val createPostSpoilerPlaceholder = "Texte du spoiler"
        override val createPostTitlePlaceholder = "Titre (optionnel)"
        override val actionSwitchAccount = "Changer de compte"
        override val actionDeleteAccount = "Supprimer un compte"
        override val editProfileTitle = "Modifier le profil"
        override val editProfileSectionPersonal = "Données personnelles"
        override val editProfileItemDisplayName = "Nom d'affichage"
        override val editProfileItemBio = "Bio"
        override val editProfileSectionFlags = "Visibilité et autorisations"
        override val editProfileItemBot = "Je suis un robot"
        override val editProfileItemLocked =
            "Exiger une approbation manuelle pour les demandes de suivi"
        override val editProfileItemDiscoverable = "Me rendre repérable dans les recherches"
        override val editProfileItemNoIndex = "Exclure mes messages de la chronologie publique"
        override val unsavedChangesTitle = "Modifications non enregistrées"
        override val messageAreYouSureExit = "Êtes-vous sûr de vouloir quitter ?"
        override val buttonSave = "Sauvegarder"
        override val editProfileSectionFields = "Champs personnalisés (expérimental)"
        override val editProfileItemFieldKey = "Clé"
        override val editProfileItemFieldValue = "Valeur"
        override val editProfileSectionImages = "Images (expérimental)"
        override val editProfileItemAvatar = "Avatar"
        override val editProfileItemHeader = "Bannière"
        override val nodeInfoTitle = "Informations sur l'instance"
        override val nodeInfoSectionRules = "Règles"
        override val nodeInfoSectionContact = "Contact"
        override val actionAddNew = "Ajouter un nouveau"
        override val directMessagesTitle = "Messages directs"

        override fun messages(count: Int): String =
            when (count) {
                1 -> "message"
                else -> "messages"
            }

        override val messageEmptyConversation =
            "C'est le début d'une conversation épique avec l'autre utilisateur."
        override val followRequiredMessage =
            "Vous devez suivre l'autre utilisateur pour pouvoir lui envoyer un message direct !"
        override val galleryTitle = "Galerie"

        override fun items(count: Int): String =
            when (count) {
                1 -> "objet"
                else -> "objets"
            }

        override val galleryFieldAlbumName = "Nom de l'album"
        override val messageEmptyAlbum = "Il semble que cet album soit encore vide… ✨"
        override val actionMove = "Déplacer"
        override val pickFromGalleryDialogTitle = "Sélectionner dans la galerie"

        override fun unreadMessages(count: Int): String =
            when (count) {
                1 -> "non lu"
                else -> "non lus"
            }

        override val messageCharacterLimitExceeded =
            "Vous avez dépassé le nombre maximum de caractères autorisés"
        override val userFieldPersonalNote = "Note personnelle"
        override val actionEditPersonalNote = "Modifier la note"
        override val actionCancelEditPersonalNote = "Annuler la note d'édition"
        override val messageVideoNsfw = "Cette vidéo peut contenir du contenu sensible 🙈"
        override val buttonLoad = "Chargement"
        override val messageAreYouSureReblog =
            "Cet article date de plus d'un mois. Êtes-vous sûr de vouloir le repartager ?"
        override val unpublishedTitle = "Articles non publiés"
        override val unpublishedSectionScheduled = "Programmés"
        override val unpublishedSectionDrafts = "Brouillons"
        override val actionSetScheduleDate = "Définir l'horaire"
        override val actionUpdateScheduleDate = "Modifier l'horaire"
        override val actionPublishDefault = "Publier maintenant"
        override val scheduleDateIndication = "Prévu pour :"
        override val messageScheduleDateInThePast =
            "Veuillez sélectionner une date de publication dans le futur"
        override val actionSaveDraft = "Enregistrer le brouillon"
        override val settingsItemDefaultPostVisibility = "Visibilité par défaut pour les messages"
        override val settingsItemDefaultReplyVisibility = "Visibilité par défaut pour les réponses"
        override val reportCategoryLegal = "Question juridique"
        override val itemOther = "Autre"
        override val reportCategorySpam = "Spam"
        override val reportCategoryViolation = "Violation des règles du serveur"
        override val messageMissingRules = "Veuillez sélectionner au moins une règle"
        override val createReportTitleUser = "Signaler"
        override val createReportTitleEntry = "Signaler poste par"
        override val createReportItemCategory = "Catégorie"
        override val createReportCommentPlaceholder =
            "Veuillez décrire le problème que vous avez rencontré"
        override val createReportItemRules = "Violation des règles"

        override fun createReportSelectedRules(count: Int) =
            when (count) {
                1 -> "règle sélectionnée"
                else -> "règles sélectionnées"
            }

        override val createReportItemForward = "Transmettre le rapport"
        override val actionReportUser = "Signaler utilisateur"
        override val actionReportEntry = "Signaler poste"
        override val actionViewDetails = "Détails"
        override val actionAddImage = "Ajouter image"
        override val actionAddImageFromGallery = "Ajouter image (galerie)"
        override val actionAddPoll = "Ajouter un sondage"
        override val actionRemovePoll = "Supprimer un sondage"
        override val createPostPollSection = "Sondage"
        override val createPostPollOptionLabel = "Option"
        override val createPostPollItemMultiple = "Autoriser les choix multiples"
        override val createPostPollItemExpirationDate = "Date d'expiration"
        override val messageInvalidPollError =
            "Sondage non valide, veuillez vérifier les options et la date d'expiration"
        override val userFeedbackFieldEmail = "Courriel ou nom d'utilisateur (facultatif)"
        override val userFeedbackFieldComment = "Commentaires"
        override val userFeedbackCommentPlaceholder =
            "Décrivez le problème que vous avez rencontré ou laissez simplement un commentaire 🖋️"
        override val changeNodeDialogTitle = "Modifier l'instance"
        override val actionQuote = "Citation"
        override val actionAddSpoiler = "Ajouter spoiler"
        override val actionRemoveSpoiler = "Supprimer spoiler"
        override val actionAddTitle = "Ajouter titre"
        override val actionRemoveTitle = "Supprimer titre"
        override val actionRevealContent = "Révéler le contenu"
        override val settingsItemExcludeRepliesFromTimeline =
            "Exclure les réponses de la chronologie"
        override val insertEmojiTitle = "Insérer un emoji"
        override val messageLoadingUsers = "Chargement des utilisateurs"
        override val actionOpenPreview = "Ouvrir l'aperçu"
        override val actionSwitchToClassicMode = "Passer en mode classique"
        override val actionSwitchToForumMode = "Passer en mode forum"
        override val settingsItemOpenGroupsInForumModeByDefault =
            "Ouvrir les groupes en mode forum par défaut"
        override val actionInsertList = "Insérer une liste"
        override val actionDismissAllNotifications = "Supprimer toutes les notifications"
        override val settingsItemMarkupMode = "Balisage pour la composition"
        override val markupModePlainText = "Texte brut"
        override val messageAltTextMissingError =
            "Certaines pièces jointes n'ont pas de texte alternatif, pensez à l'insérer pour des raisons d'accessibilité"
        override val buttonPublishAnyway = "Publier quand même"
        override val actionCopyToClipboard = "Copier dans le presse-papiers"
        override val actionSaveToCalendar = "Enregistrer dans le calendrier"
        override val settingsItemMaxPostBodyLines = "Nombre maximal lignes corps des postes"
        override val settingsOptionUnlimited = "Illimité"
        override val settingsAboutLicences = "Licences"
        override val settingsOptionBackgroundNotificationCheck = "Vérifier les notifications en arrière-plan"
        override val settingsSubtitleBackgroundNotificationRestricted =
            "Veuillez activer l'activité en arrière-plan pour l'app dans les paramètres du système"
        override val settingsSubtitleBackgroundNotificationNotRestricted =
            "Pas de restriction du système pour l'activité en arrière-plan "
        override val durationNever = "Jamais"
        override val unreadNotificationTitle = "Consultez vos notifications !"

        override fun unreadNotificationBody(count: Int) =
            when (count) {
                1 -> "Il y a $count article dans le 🗑️"
                else -> "Il y a $count articles dans le 🗑️"
            }

        override val settingsAboutUserManual = "Manuel de l'utilisateur"
        override val editProfileItemHideCollections =
            "Rendre les listes de suiveurs et de suivis privées"
        override val settingsAboutMatrix = "Rejoindre la salle Matrix"
        override val settingsAutoloadImages = "Charger les images automatiquement"
        override val circleTypeGroup = "Groupes"
        override val circleTypePredefined = "Canaux"
        override val circleTypeUserDefined = "Tes listes"
        override val settingsItemNotificationMode = "Mode notifications"
        override val settingsNotificationModeDisabled = "Désactivé"
        override val settingsNotificationModePull = "Tirer"
        override val settingsNotificationModePullExplanation = "en arrière-plan"
        override val settingsNotificationModePush = "Pousser"
        override val settingsNotificationModePushExplanation = "UnifiedPush"
        override val settingsItemPushNotificationState = "État des notifications push"
        override val settingsPushNotificationStateUnsupported = "sans support"
        override val settingsPushNotificationStateInitializing = "Initialisation…"
        override val settingsPushNotificationStateNoDistributors = "Pas de distributeurs disponible"
        override val settingsPushNotificationStateNoDistributorSelected =
            "Sélectionner un distributeur"
        override val settingsPushNotificationStateIdle = "Au repos"
        override val settingsPushNotificationStateEnabled = "Actif"
        override val experimental = "expérimental"
        override val loginTitle = "🦝 Bienvenus ! 🦝"
        override val loginSubtitle =
            "Connectez-vous à une instance pour commencer à suivre d'autres personnes, créer de nouveaux messages ou des réponses et gérer vos favoris ou vos signets."
        override val moreInfo = "En savoir plus"
        override val loginMoreInfoBottomSheetContent =
            "Le flux de connexion commencera dans l'application en sélectionnant l'instance, " +
                "après quoi vous continuerez le flux OAuth2 dans un navigateur web." +
                "\n\nSi vous n'avez pas de compte, veuillez d'abord choisir une instance et vous inscrire dans votre navigateur."
        override val loginFriendicaHeader = "Je suis sur Friendica"
        override val loginMastodonHeader = "Je suis sur Mastodon"
        override val helpMeChooseAnInstance = "Aidez-moi à choisir une instance"
        override val loginOtherHeader = "Autre (Pleroma, etc.)"
        override val exempliGratia = "e. g."
    }
