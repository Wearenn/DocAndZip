INSERT INTO "type" ("type_id", "type") VALUES (1, 'texte');
INSERT INTO "type" ("type_id", "type") VALUES (2, 'audio');
INSERT INTO "type" ("type_id", "type") VALUES (3, 'video');
INSERT INTO "type" ("type_id", "type") VALUES (4, 'binaire');

INSERT INTO "document" ("nom", "chemin", "type_id", "date_ajout") VALUES ('cv', '~/Documents/Tests/cv.txt', 1, '2022-03-14');
INSERT INTO "document" ("nom", "chemin", "type_id", "date_ajout") VALUES ('memoire d alternance', '~/Documents/Tests/memoire_alternance.txt', 1, '2022-03-14');
INSERT INTO "document" ("nom", "chemin", "type_id", "date_ajout") VALUES ('vivien.exe', '~/Documents/Tests/vivien.exe', 4, '2022-03-14');
INSERT INTO "document" ("nom", "chemin", "type_id", "date_ajout") VALUES ('cours CGL', '~/Documents/Tests/cours.avi', 3, '2022-03-14');
INSERT INTO "document" ("nom", "chemin", "type_id", "date_ajout") VALUES ('sous le vent', '~/Documents/Tests/garou.mp3', 2, '2022-03-14');
