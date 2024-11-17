package com.livefast.eattrash.raccoonforfriendica.core.l10n.messages

internal val PtStrings =
    object : DefaultStrings() {
        override val messageConfirmExit = "Toque novamente em 🔙 para sair"
        override val messageAreYouSure = "Tem a certeza de que pretende continuar?"
        override val messageSuccess = "Operação concluída com sucesso!"
        override val messageGenericError = "Ocorreu um erro inesperado"
        override val messageInvalidField = "Campo inválido"
        override val messageMissingField = "Campo em falta"
        override val messageEmptyList = "Não há nada para mostrar aqui 🗑️️"
        override val buttonConfirm = "Confirmar"
        override val buttonOk = "OK"
        override val buttonClose = "Fechar"
        override val buttonCancel = "Cancelar"
        override val systemDefault = "Sistema"
        override val settingsThemeLight = "Claro"
        override val settingsThemeDark = "Escuro"
        override val settingsThemeBlack = "Preto (AMOLED)"
        override val sectionTitleHome = "Linha do tempo"
        override val sectionTitleExplore = "Explorar"
        override val sectionTitleInbox = "Caixa de entrada"
        override val sectionTitleProfile = "Perfil"
        override val barThemeOpaque = "Opaco"
        override val barThemeTransparent = "Transparente"
        override val timelineAll = "Todos"
        override val timelineSubscriptions = "Subscrições"
        override val timelineLocal = "Local"
        override val nodeVia = "via"
        override val timelineEntryInReplyTo = "em resposta a"
        override val timelineEntryRebloggedBy = "re-compartilhado por"

        override fun accountFollower(count: Int) =
            when (count) {
                1 -> "seguidor"
                else -> "seguidores"
            }

        override fun accountFollowing(count: Int) =
            when (count) {
                1 -> "seguido"
                else -> "seguidos"
            }

        override val accountAge = "idade da conta"
        override val dateYearShort = "a"
        override val dateMonthShort = "m"
        override val dateDayShort = "d"
        override val timeHourShort = "h"
        override val timeMinuteShort = "min"
        override val timeSecondShort = "s"
        override val accountSectionPosts = "Mensagens"
        override val accountSectionAll = "Mensagens e respostas"
        override val accountSectionPinned = "Fixado"
        override val accountSectionMedia = "Media"
        override val postTitle = "Publicar"
        override val settingsTitle = "Definições"
        override val settingsHeaderGeneral = "Geral"
        override val settingsItemLanguage = "Idioma"
        override val settingsHeaderLookAndFeel = "Aspeto e sensação"
        override val settingsItemTheme = "Tema da interface do utilizador"
        override val settingsItemFontFamily = "Família de letras"
        override val settingsItemDynamicColors = "Material You"
        override val settingsItemDynamicColorsSubtitle = "gera uma paleta com base no seu fundo"
        override val settingsItemThemeColor = "Cor do tema"
        override val settingsItemThemeColorSubtitle =
            "apenas aplicado se “Material You” estiver desativado"
        override val themeColorPurple = "Polvo portentoso"
        override val themeColorBlue = "Baleia bailarina"
        override val themeColorLightBlue = "Golfinho gostoso"
        override val themeColorGreen = "Sapo silencioso"
        override val themeColorYellow = "Ouriço ossudo"
        override val themeColorOrange = "Raposa rica"
        override val themeColorRed = "Caranguejo crocante"
        override val themeColorPink = "Unicórnio único"
        override val themeColorGray = "Guaxinim guerreiro"
        override val themeColorWhite = "Urso universitário"
        override val messageUserUnlogged =
            "É necessário ter sessão iniciada para aceder a esta secção 🪵"
        override val buttonLogin = "Iniciar sessão"
        override val fieldNodeName = "Nome da instância"
        override val fieldUsername = "Nome de utilizador"
        override val fieldPassword = "Palavra-passe"
        override val actionLogout = "Terminar sessão"
        override val relationshipStatusFollowing = "Seguir"
        override val relationshipStatusFollowsYou = "Segue-o"
        override val relationshipStatusMutual = "Mútuo"
        override val relationshipStatusRequestedToOther = "Pedido enviado"
        override val relationshipStatusRequestedToYou = "Pedido pendente"
        override val notificationTypeEntry = "publicou uma mensagem"
        override val notificationTypeFavorite = "adicionou sua publicação aos favoritos"
        override val notificationTypeFollow = "começou a seguir-te"
        override val notificationTypeFollowRequest = "enviou-lhe um pedido para o seguir"
        override val notificationTypeMention = "mencionou-o"
        override val notificationTypePoll = "uma sondagem em que participou foi encerrada"
        override val notificationTypeReblog = "partilhou novamente a sua mensagem"
        override val notificationTypeUpdate = "actualizou uma publicação que partilhou novamente"
        override val exploreSectionHashtags = "Hashtags"
        override val exploreSectionLinks = "Ligações"
        override val exploreSectionSuggestions = "Para si"

        override fun hashtagPeopleUsing(count: Int) =
            when (count) {
                1 -> "pessoa está a falar sobre isso"
                else -> "pessoas estão a falar sobre isso"
            }

        override val feedTypeTitle = "Tipo de fee"
        override val followerTitle = "Seguidore"
        override val followingTitle = "Seguind"
        override val actionFollow = "Segui"
        override val actionUnfollow = "Deixar de segui"
        override val actionDeleteFollowRequest = "Cancelar pedido de seguiment"
        override val sidebarAnonymousTitle = "Anónimo"
        override val sidebarAnonymousMessage =
            "Bem-vindo/a a Raccoon!\n\nPode iniciar sessão na sua instância a qualquer momento a partir do ecrã Perfil.\n\nAproveite a Friendica!"
        override val bookmarksTitle = "Marcadores"
        override val favoritesTitle = "Favoritos"
        override val followedHashtagsTitle = "Hashtags seguidas"
        override val infoEdited = "editado"

        override fun extendedSocialInfoFavorites(count: Int) =
            when (count) {
                1 -> "favorito"
                else -> "favoritos"
            }

        override fun extendedSocialInfoReblogs(count: Int) =
            when (count) {
                1 -> "partilha"
                else -> "partilhas"
            }

        override val actionMuteNotifications = "Silenciar notificações"
        override val createPostTitle = "Criar mensagem"
        override val messagePostEmptyText = "Fornecer um anexo, uma sondagem ou algum texto"
        override val visibilityPublic = "Público"
        override val visibilityUnlisted = "Não listado"
        override val visibilityPrivate = "Apenas seguidores"
        override val visibilityDirect = "Apenas menções"
        override val createPostBodyPlaceholder = "O teu novo post fantástico… 🪄"
        override val createPostAttachmentsSection = "Anexos"
        override val actionEdit = "Editar"
        override val pictureDescriptionPlaceholder = "Descrição da imagem"
        override val insertLinkDialogTitle = "Inserir link"
        override val insertLinkFieldAnchor = "Âncora"
        override val insertLinkFieldUrl = "URL"
        override val selectUserDialogTitle = "Selecionar um utilizador"
        override val selectUserSearchPlaceholder = "nome de utilizador ou identificador"
        override val searchSectionUsers = "Utilizadores"
        override val searchPlaceholder = "Pesquisar no Fediverso"
        override val messageSearchInitialEmpty = "Começar a escrever algo"
        override val topicTitle = "Tópico"
        override val threadTitle = "Tópico"
        override val buttonLoadMoreReplies = "Carregar mais respostas"
        override val postSensitive = "Conteúdo sensível"
        override val actionCreateThreadInGroup = "Publicar para"
        override val settingsHeaderNsfw = "NSFW"
        override val settingsItemIncludeNsfw = "Incluir conteúdos NSFW"
        override val settingsItemBlurNsfw = "Desfocar media NSFW"
        override val settingsItemDefaultTimelineType = "Tipo de linha cronológica predefinida"
        override val actionDelete = "Apagar"
        override val actionShare = "Partilhar"
        override val actionCopyUrl = "Copiar ligação"
        override val messageTextCopiedToClipboard = "Copiado para a área de transferência! 📋"
        override val contentScaleFit = "Ajuste de aspeto"
        override val contentScaleFillWidth = "Largura do preenchimento"
        override val contentScaleFillHeight = "Altura do preenchimento"
        override val contentScaleTitle = "Modo de escala"
        override val shareAsUrl = "Partilhar como URL"
        override val shareAsFile = "Partilhar como ficheiro"
        override val actionMute = "Silenciar"
        override val actionUnmute = "Tirar o som"
        override val settingsItemBlockedAndMuted = "Gerir filtros"
        override val manageBlocksSectionMuted = "Silenciado"
        override val manageBlocksSectionBlocked = "Bloqueado"
        override val actionBlock = "Bloquear"
        override val actionUnblock = "Desbloquear"
        override val loginMethodBasic = "antigo"
        override val actionPin = "Fixar no perfil"
        override val actionUnpin = "Desmarcar do perfil"
        override val settingsSectionDebug = "Depurar"
        override val settingsAbout = "Informações sobre a aplicação"
        override val settingsAboutAppVersion = "Versão"
        override val settingsAboutChangelog = "Registo de alterações"
        override val settingsAboutViewGithub = "Ver no GitHub"
        override val settingsAboutReportIssue = "Reportar um problema"
        override val settingsAboutViewFriendica = "Ver no Friendica"
        override val manageCirclesTitle = "Círculos"
        override val createCircleTitle = "Criar círculo"
        override val editCircleTitle = "Editar círculo"
        override val circleEditFieldName = "Nome"
        override val circleAddUsersDialogTitle = "Selecionar utilizadores para adicionar"
        override val visibilityCircle = "Círculo"
        override val selectCircleDialogTitle = "Selecionar um círculo"
        override val messagePostInvalidVisibility = "Selecione uma opção de visibilidade válida"
        override val settingsItemFontScale = "Tamanho da letra"
        override val fontScaleNormal = "Normal"
        override val fontScaleSmaller = "Mais pequeno"
        override val fontScaleSmallest = "Mais pequeno"
        override val fontScaleLarger = "Maior"
        override val fontScaleLargest = "Maior"
        override val settingsItemUrlOpeningMode = "Modo de abertura do URL"
        override val urlOpeningModeExternal = "Navegador externo"
        override val urlOpeningModeCustomTabs = "Guias personalizadas"
        override val urlOpeningModeInternal = "Vista interna da Web"
        override val dialogErrorTitle = "Oops…"
        override val messagePollVoteErrorBody =
            "Infelizmente, sou apenas um programador móvel e não posso adicionar métodos back-end em falta!"
        override val buttonPollErrorOpenIssue =
            "Verifica este problema e coloca um 👍 para que os programadores saibam que pode valer a pena implementá-lo."
        override val actionVote = "Ver no GitHub"
        override val pollExpired = "Votação"
        override val shortUnavailable = "Expirado"

        override fun pollVote(count: Int): String =
            when (count) {
                1 -> "voto"
                else -> "votos"
            }

        override val pollExpiresIn = "Expira em"
        override val actionHideResults = "Mostrar resultados"
        override val actionShowResults = "Ocultar resultados"
        override val inboxConfigureFilterDialogTitle = "Configurar filtros"
        override val inboxConfigureFilterDialogSubtitle =
            "Se algum valor for desmarcado, o filtro só devolverá elementos não lidos"
        override val notificationTypeEntryName = "Notificações de publicação"
        override val notificationTypeFavoriteName = "Favoritos"
        override val notificationTypeFollowName = "Novos seguidores"
        override val notificationTypeFollowRequestName = "Pedidos de seguimento"
        override val notificationTypeMentionName = "Menções e respostas"
        override val notificationTypePollName = "Sondagens"
        override val notificationTypeReblogName = "Re-compartilhamentos"
        override val notificationTypeUpdateName = "Actualizações de publicações"
        override val muteDurationIndefinite = "Indefinido"
        override val selectDurationDialogTitle = "Selecionar duração"
        override val muteDurationItem = "Não verá quaisquer mensagens deste utilizador durante"
        override val muteDisableNotificationsItem = "Desativar notificações"
        override val actionSendFollowRequest = "Enviar pedido"
        override val postBy = "por"
        override val customOption = "Personalizar"
        override val colorPickerDialogTitle = "Selecionar uma cor"
        override val followRequestsTitle = "Seguir pedidos"
        override val actionAccept = "Aceitar"
        override val actionReject = "Rejeitar"
        override val actionHideContent = "Ocultar conteúdo"
        override val messageEmptyInbox =
            "🎉 Está todos em dia! 🎉\n\nVerá novas notificações nesta página assim que chegarem"
        override val createPostSpoilerPlaceholder = "Texto do spoiler"
        override val createPostTitlePlaceholder = "Título (opcional)"
        override val actionSwitchAccount = "Mudar de conta"
        override val actionDeleteAccount = "Apagar conta"
        override val editProfileTitle = "Editar perfil"
        override val editProfileSectionPersonal = "Dados pessoais"
        override val editProfileItemDisplayName = "Nome de apresentação"
        override val editProfileItemBio = "Biografia"
        override val editProfileSectionFlags = "Visibilidade e permissões"
        override val editProfileItemBot = "Eu sou um bot"
        override val editProfileItemLocked = "Exigir aprovação manual para pedidos de seguimento"
        override val editProfileItemDiscoverable = "Tornar-me detetável nas pesquisas"
        override val editProfileItemNoIndex =
            "Excluir as minhas publicações das linhas de tempo públicas"
        override val unsavedChangesTitle = "Alterações não guardadas"
        override val messageAreYouSureExit = "Tem a certeza de que pretende sair?"
        override val buttonSave = "Guardar"
        override val editProfileSectionFields = "Campos personalizados (experimental)"
        override val editProfileItemFieldKey = "Chave"
        override val editProfileItemFieldValue = "Valor"
        override val editProfileSectionImages = "Imagens (experimental)"
        override val editProfileItemAvatar = "Avatar"
        override val editProfileItemHeader = "Banner"
        override val nodeInfoTitle = "Informação do nó"
        override val nodeInfoSectionRules = "Regras"
        override val nodeInfoSectionContact = "Contacto"
        override val actionAddNew = "Adicionar novo"
        override val directMessagesTitle = "Mensagens diretas"

        override fun messages(count: Int): String =
            when (count) {
                1 -> "mensagem"
                else -> "mensagens"
            }

        override val messageEmptyConversation =
            "Este é o início da sua conversa épica com"
        override val followRequiredMessage =
            "É necessário seguir o outro utilizador para poder enviar uma mensagem direta!"
        override val galleryTitle = "Galeria"

        override fun items(count: Int): String =
            when (count) {
                1 -> "elemento"
                else -> "elementos"
            }

        override val galleryFieldAlbumName = "Nome do álbum"
        override val messageEmptyAlbum = "Parece que este álbum ainda está vazio… ✨"
        override val actionMove = "Mover"
        override val pickFromGalleryDialogTitle = "Selecionar da galeria"

        override fun unreadMessages(count: Int): String =
            when (count) {
                1 -> "não lido"
                else -> "não lidos"
            }

        override val messageCharacterLimitExceeded =
            "Excedeu o número máximo de caracteres permitido"
        override val userFieldPersonalNote = "Nota pessoal"
        override val actionEditPersonalNote = "Editar nota"
        override val actionCancelEditPersonalNote = "Cancelar nota de edição"
        override val messageVideoNsfw = "Este vídeo pode conter conteúdo sensível 🙈"
        override val buttonLoad = "Carregar"
        override val messageAreYouSureReblog =
            "Esta publicação tem mais de um mês. Tem a certeza de que quere voltar a partilhá-la?"
        override val unpublishedTitle = "Elementos não publicados"
        override val unpublishedSectionScheduled = "Programado"
        override val unpublishedSectionDrafts = "Rascunhos"
        override val actionSetScheduleDate = "Definir horário"
        override val actionUpdateScheduleDate = "Alterar calendário"
        override val actionPublishDefault = "Publicar agora"
        override val scheduleDateIndication = "Programado para:"
        override val messageScheduleDateInThePast = "Selecionar uma data de agendamento no futuro"
        override val actionSaveDraft = "Guardar rascunho"
        override val settingsItemDefaultPostVisibility = "Visibilidade predefinida para mensagens"
        override val settingsItemDefaultReplyVisibility = "Visibilidade predefinida para respostas"
        override val reportCategoryLegal = "Questão legal"
        override val itemOther = "Outros"
        override val reportCategorySpam = "Spam"
        override val reportCategoryViolation = "Violação das regras do servidor"
        override val messageMissingRules = "Selecione pelo menos uma regra"
        override val createReportTitleUser = "Denunciar"
        override val createReportTitleEntry = "Denunciar publicação por"
        override val createReportItemCategory = "Categoria"
        override val createReportCommentPlaceholder = "Descreva o problema que encontrou"
        override val createReportItemRules = "Regras violadas"

        override fun createReportSelectedRules(count: Int) =
            when (count) {
                1 -> "regra selecionada"
                else -> "regras selecionadas"
            }

        override val createReportItemForward = "Reencaminhar relatório"
        override val actionReportUser = "Denunciar utilizador"
        override val actionReportEntry = "Comunicar correio"
        override val actionViewDetails = "Detalhes"
        override val actionAddImage = "Adicionar imagem"
        override val actionAddImageFromGallery = "Adicionar imagem (galeria de média)"
        override val actionAddPoll = "Adicionar sondagem"
        override val actionRemovePoll = "Remover sondagem"
        override val createPostPollSection = "Sondagem"
        override val createPostPollOptionLabel = "Opção"
        override val createPostPollItemMultiple = "Permitir escolha múltipla"
        override val createPostPollItemExpirationDate = "Data de validade"
        override val messageInvalidPollError =
            "Sondagem inválida, verifique as opções e a data de expiração"
        override val userFeedbackFieldEmail = "E-mail ou nome de utilizador (opcional)"
        override val userFeedbackFieldComment = "Comentários"
        override val userFeedbackCommentPlaceholder =
            "Descreva o problema que encontrou ou deixe apenas um feedback 🖋️"
        override val changeNodeDialogTitle = "Alterar instância"
        override val actionQuote = "Citação"
        override val actionAddSpoiler = "Adicionar spoiler"
        override val actionRemoveSpoiler = "Remover spoiler"
        override val actionAddTitle = "Adicionar título"
        override val actionRemoveTitle = "Remover título"
        override val actionRevealContent = "Revelar conteúdo"
        override val settingsItemExcludeRepliesFromTimeline = "Excluir respostas da linha de tempo"
        override val insertEmojiTitle = "Inserir emoji"
        override val messageLoadingUsers = "Carregar utilizadores"
        override val actionOpenPreview = "Abrir pré-visualização"
        override val actionSwitchToClassicMode = "Mudar para o modo clássico"
        override val actionSwitchToForumMode = "Mudar para o modo de fórum"
        override val settingsItemOpenGroupsInForumModeByDefault =
            "Abrir grupos no modo de fórum por defeito"
        override val actionInsertList = "Inserir lista"
        override val actionDismissAllNotifications = "Ignorar todas as notificações"
        override val settingsItemMarkupMode = "Marcação para composição"
        override val markupModeBBCode = "BBCode"
        override val markupModeHTML = "HTML"
        override val markupModeMarkdown = "Markdown"
        override val markupModePlainText = "Texto simples"
        override val messageAltTextMissingError =
            "Alguns anexos não têm um texto alternativo, considere a possibilidade de o inserir para fins de acessibilidade"
        override val buttonPublishAnyway = "Publicar na mesma"
        override val actionCopyToClipboard = "Copiar para a área de transferência"
        override val calendarTitle = "Calendário"
        override val actionSaveToCalendar = "Guardar no calendário"
        override val settingsItemMaxPostBodyLines = "Máximo de linhas do corpo do post"
        override val settingsOptionUnlimited = "Ilimitado"
        override val settingsAboutLicences = "Licenças"
        override val settingsOptionBackgroundNotificationCheck =
            "Verificar se há notificações em segundo plano"
        override val settingsSubtitleBackgroundNotificationRestricted =
            "Ativar a atividade em segundo plano para a aplicação nas definições do sistema"
        override val settingsSubtitleBackgroundNotificationNotRestricted =
            "Sem restrições de sistema para atividade em segundo plano"
        override val durationNever = "Nunca"
        override val unreadNotificationTitle = "Verifique as suas notificações!"

        override fun unreadNotificationBody(count: Int) =
            when (count) {
                1 -> "Existe um elemento $count no seu 🗑️"
                else -> "Existem $count elementos no seu 🗑️"
            }

        override val settingsAboutUserManual = "Manual do utilizador"
        override val editProfileItemHideCollections =
            "Tornar privadas as listas de seguidores e de seguidos"
        override val settingsAboutMatrix = "Entrar na sala Matrix"
        override val settingsAutoloadImages = "Modo de carregamento de imagens"
        override val circleTypeGroup = "Grupos"
        override val circleTypePredefined = "Canais"
        override val circleTypeUserDefined = "As suas listas"
        override val settingsItemNotificationMode = "Modo notificações"
        override val settingsNotificationModeDisabled = "Desativado"
        override val settingsNotificationModePull = "Puxar"
        override val settingsNotificationModePullExplanation = "em segundo plano"
        override val settingsNotificationModePush = "Empurrar"
        override val settingsNotificationModePushExplanation = "UnifiedPush"
        override val settingsItemPushNotificationState = "Estado das notificações push"
        override val settingsPushNotificationStateUnsupported = "Não suportadas"
        override val settingsPushNotificationStateInitializing = "A inicializar…"
        override val settingsPushNotificationStateNoDistributors = "Nenhum distribuidor disponível"
        override val settingsPushNotificationStateNoDistributorSelected = "Selecionar distribuidor"
        override val settingsPushNotificationStateIdle = "Inativo"
        override val settingsPushNotificationStateEnabled = "Ativo"
        override val experimental = "experimental"
        override val loginTitle = "🦝 Bem-vindo! 🦝"
        override val loginSubtitle =
            "Inicie sessão numa instância para começar a seguir outras pessoas, criar novas mensagens ou respostas e gerir os seus favoritos ou marcadores."
        override val moreInfo = "Descobrir mais"
        override val loginMoreInfoBottomSheetContent =
            "O fluxo de início de sessão será iniciado na aplicação selecionando a instância, " +
                "após o que continuará o fluxo OAuth2 num navegador Web." +
                "\n\nSe não tiver uma conta, escolha uma instância e registe-se primeiro no seu navegador."
        override val loginFriendicaHeader = "Estou no Friendica"
        override val loginMastodonHeader = "Estou no Mastodon"
        override val helpMeChooseAnInstance = "Ajude-me a escolher uma instância"
        override val exempliGratia = "e. g."
        override val newAccountTitle = "Adicionar conta"
        override val imageLoadingModeAlways = "Sempre"
        override val imageLoadingModeOnDemand = "A pedido"
        override val imageLoadingModeOnWiFi = "Em WiFi"
        override val messageReplyVisibilityGreaterThanParentError =
            "Está a publicar uma resposta com uma visibilidade mais ampla do que a publicação original"
        override val settingsItemCrashReportEnabled = "Permitir relatórios anónimos de acidentes"
        override val messageRestartToApplyChanges = "Reinicie a aplicação para aplicar as alterações"
        override val settingsItemHideNavigationBarWhileScrolling =
            "Ocultar a barra de navegação ao rolar"
        override val settingsItemAppIcon = "Ícone da aplicação"
        override val appIconDefault = "Predefinição"
        override val appIconClassical = "Clássico"
        override val settingsItemExport = "Exportar as definições"
        override val settingsItemImport = "Importar as definições"
        override val actionExport = "Exportar"
        override val actionChangeMarkupMode = "Alterar tipo de marcação"
        override val confirmChangeMarkupMode =
            "Se alterar o tipo de marcação, toda a formatação se perderá. Continuar na mesma?"
    }
