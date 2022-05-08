CREATE TABLE IF NOT EXISTS chant (
    id bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    titre varchar(255) NOT NULL,
    categorie varchar(255) NOT NULL,
    langue varchar(255) NOT NULL,
    temps varchar(255),
    contenu text NOT NULL
);

INSERT INTO chant SELECT * FROM
(SELECT 1,'Approchons-nous de la table', 'Chants de communion', 'Français', 'Ordinaire', '[{"type":"couplet","numero":1,"contenu": "Approchons-nous"},{"type":"couplet","numero":2,"contenu": "Voici l´admirable"}]') x 
WHERE NOT EXISTS(SELECT * FROM chant WHERE id = 1);