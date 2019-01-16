
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

----------------------------------------------------------------------------


    create table semaine (
        id bigint not null,
        semaine_nom varchar(255) not null,
        primary key (id)
    );
    
    alter table commande
    add  semaine_id bigint not null;

	alter table commande 
	add constraint FKDC160A7AB1783F7A 
	foreign key (semaine_id) 
	references semaine(id);
    
    
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('1', 'S1');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('2', 'S2');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('3', 'S3');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('4', 'S4');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('5', 'S5');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('6', 'S6');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('7', 'S7');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('8', 'S8');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('9', 'S9');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('10', 'S10');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('11', 'S11');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('12', 'S12');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('13', 'S13');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('14', 'S14');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('15', 'S15');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('16', 'S16');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('17', 'S17');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('18', 'S18');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('19', 'S19');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('20', 'S20');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('21', 'S21');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('22', 'S22');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('23', 'S23');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('24', 'S24');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('25', 'S25');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('26', 'S26');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('27', 'S27');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('28', 'S28');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('29', 'S29');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('30', 'S30');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('31', 'S31');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('32', 'S32');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('33', 'S33');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('34', 'S34');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('35', 'S35');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('36', 'S36');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('37', 'S37');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('38', 'S38');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('39', 'S39');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('40', 'S40');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('41', 'S41');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('42', 'S42');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('43', 'S43');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('44', 'S44');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('45', 'S45');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('46', 'S46');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('47', 'S47');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('48', 'S48');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('49', 'S49');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('50', 'S50');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('51', 'S51');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('52', 'S52');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('53', 'S53');
INSERT INTO `semaine` (`id`, `semaine_nom`) VALUES ('54', 'S54');

