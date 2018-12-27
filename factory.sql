
    create table article (
        id bigint not null AUTO_INCREMENT,
        article_numero varchar(255) not null,
        primary key (id)
    );

    create table commande (
        id bigint not null AUTO_INCREMENT,
        commande_numero varchar(255) not null,
        article_id bigint not null,
        ouvrier_id bigint not null,
        statut_id bigint not null,
        primary key (id)
    );

    create table ouvrier (
        id bigint not null AUTO_INCREMENT,
        ouvrier_nom varchar(255) not null,
        ouvrier_prenom varchar(255) not null,
        table_usine_id bigint,
        primary key (id)
    );

    create table statut (
        id bigint not null ,
        statut_nom varchar(255) not null,
        primary key (id)
    );

    create table table_usine (
        id bigint not null AUTO_INCREMENT,
        table_numero varchar(255) not null,
        primary key (id)
    );

    alter table commande 
        add constraint FKDC160A7ADE2DC5FA 
        foreign key (article_id) 
        references article(id);

    alter table commande 
        add constraint FKDC160A7A96902D3A 
        foreign key (ouvrier_id) 
        references ouvrier(id);

    alter table commande 
        add constraint FKDC160A7A4F6988DA 
        foreign key (statut_id) 
        references statut(id);

    alter table ouvrier 
        add constraint FKBE2EF074FBFF741A 
        foreign key (table_usine_id) 
        references table_usine(id);


INSERT INTO `statut` (`id`, `statut_nom`) VALUES ('0', 'Non initié');
INSERT INTO `statut` (`id`, `statut_nom`) VALUES ('1', 'En cours');
INSERT INTO `statut` (`id`, `statut_nom`) VALUES ('2', 'Terminé');
