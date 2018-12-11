
    create table article (
        id bigint not null AUTO_INCREMENT,
        article_numero varchar(255) not null,
		commande_numero varchar(255),
        primary key (id)
    );

    create table ouvrier (
        id bigint not null AUTO_INCREMENT,
        ouvrier_nom varchar(255) not null,
        ouvrier_prenom varchar(255) not null,
        primary key (id)
    );

    create table realisation (
        id bigint not null AUTO_INCREMENT,
        date_debut date,
        date_fin date,
        article_id bigint,
        ouvrier_id bigint not null,
        statut_id bigint not null,
        primary key (id)
    );

    create table statut (
        id bigint not null,
        statut_nom varchar(255) not null,
        primary key (id)
    );

    create table table_usine (
        id bigint not null AUTO_INCREMENT,
        table_numero varchar(255) not null,
        ouvrier_id bigint,
        primary key (id)
    );

    alter table realisation 
        add constraint FK8F60B88D41665DDA 
        foreign key (article_id) 
        references article(id);

    alter table realisation 
        add constraint FK8F60B88DF9C8C51A 
        foreign key (ouvrier_id) 
        references ouvrier(id);

    alter table Realisation 
        add constraint FK8F60B88D18CE74FA 
        foreign key (statut_id) 
        references statut(id);

    alter table table_usine 
        add constraint FK1C987D74F9C8C51A 
        foreign key (ouvrier_id) 
        references ouvrier(id);


INSERT INTO `factory`.`statut` (`id`, `statut_nom`) VALUES ('0', 'Non initié');
INSERT INTO `factory`.`statut` (`id`, `statut_nom`) VALUES ('1', 'En cours');
INSERT INTO `factory`.`statut` (`id`, `statut_nom`) VALUES ('2', 'Terminé');
