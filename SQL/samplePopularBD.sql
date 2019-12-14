
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER //
CREATE FUNCTION `idade` (dta date) RETURNS INT
BEGIN
RETURN TIMESTAMPDIFF(YEAR, dta, CURDATE());
END //
DELIMITER ;



INSERT INTO MediaCenter.Conta(username, senha, isAdmin, email) VALUES ('Tonecas', 'gandaFixe',1,"tonecasofthequecas@gmail.com");
INSERT INTO MediaCenter.Conta(username, senha, isAdmin, email) VALUES ('BigBoyTintz2', 'slashcity',1,"tintz2minecraft@gmail.com");
INSERT INTO MediaCenter.Conta(username, senha, isAdmin, email) VALUES ('PedroMyGod', 'flexerBoy',1,"diamante4@gmail.com");
INSERT INTO MediaCenter.Conta(username, senha, isAdmin, email) VALUES ('AlexisTexas', 'googleMe',0,"alexistexas@gmail.com");

INSERT INTO MediaCenter.Colecao (idColecao, criador, titulo, categoria, isPublic) VALUES(1,'Tonecas','Mood','Mixed',0);
INSERT INTO MediaCenter.Colecao (idColecao, criador, titulo, categoria, isPublic) VALUES(2,'BigBoyTintz2','Cosmic Noise','VaporWave',1);

INSERT INTO MediaCenter.MediaID(idMedia)value(1);
INSERT INTO MediaCenter.Musica (idMusica, titulo, artista, dataInclusao,uploader, isPublic,caminho) VALUES(1, 'I THINK', 'Tyler The Creator', '2019-12-02','Tonecas', 1, 'mediaCenter/music/ITHINK.mp3');
INSERT INTO MediaCenter.MediaID(idMedia)value(2);
INSERT INTO MediaCenter.Musica (idMusica, titulo, artista, dataInclusao, uploader, isPublic,caminho) VALUES(2, 'Lottery', 'Kali Uchis', '2019-12-02','Tonecas', 1, 'mediaCenter/music/lottery.mp3');
INSERT INTO MediaCenter.MediaID(idMedia)value(3);
INSERT INTO MediaCenter.Musica (idMusica, titulo, artista, dataInclusao, uploader, isPublic,caminho) VALUES(3, 'My Longest Yeah Boy Ever', 'yeboiiiiii', '2019-12-02','Tonecas', 1, 'mediaCenter/music/yeboiiiiiiiiiiiiiiiiiiii.mp3');
INSERT INTO MediaCenter.MediaID(idMedia)value(4);
INSERT INTO MediaCenter.Musica (idMusica, titulo, artista, dataInclusao, uploader, isPublic,caminho) VALUES(4, 'Intercept', 'Unfound', '2019-12-01','BigBoyTintz2',1, 'mediaCenter/music/intercept.mp3');
INSERT INTO MediaCenter.MediaID(idMedia)value(5);
INSERT INTO MediaCenter.Musica (idMusica, titulo, artista, dataInclusao, uploader, isPublic,caminho) VALUES(5, 'Lyra SoundTrack', 'IDK', '2019-12-01','PedroMyGod',1, 'mediaCenter/music/Lyra.mp3');
INSERT INTO MediaCenter.MediaID(idMedia)value(6);
INSERT INTO MediaCenter.Musica (idMusica, titulo, artista, dataInclusao, uploader, isPublic,caminho) VALUES(6, 'Moans', 'AlexisTexas', '2019-12-01','AlexisTexas',1,'mediaCenter/music/moans.mp3');
INSERT INTO MediaCenter.MediaID(idMedia)value(7);
INSERT INTO MediaCenter.Video (idVideo, titulo, dataInclusao, uploader, isPublic,caminho) VALUES(7, 'Slash City Parte 2', '2019-12-01','BigBoyTintz2',1,'mediaCenter\video\SlashCity.mp4');
INSERT INTO MediaCenter.MediaID(idMedia)value(8);
INSERT INTO MediaCenter.Video (idVideo, titulo, dataInclusao, uploader, isPublic,caminho) VALUES(8, 'Ricardo Milos Home Party', '2019-12-01','Tonecas',1,'mediaCenter\video\SexGod.mp4');


INSERT INTO MediaCenter.ColMed(idColMed,idMedia,idColecao) VALUES(1,1,1);
INSERT INTO MediaCenter.ColMed(idColMed,idMedia,idColecao) VALUES(2,2,1);
INSERT INTO MediaCenter.ColMed(idColMed,idMedia,idColecao) VALUES(3,3,1);
INSERT INTO MediaCenter.ColMed(idColMed,idMedia,idColecao) VALUES(4,4,1);

INSERT INTO MediaCenter.Amizade (idAmizade, user1, user2) VALUES(1, 'Tonecas', 'BigBoyTintz2');
INSERT INTO MediaCenter.Amizade (idAmizade, user1, user2) VALUES(2, 'Tonecas', 'PedroMyGod');
INSERT INTO MediaCenter.Amizade (idAmizade, user1, user2) VALUES(3, 'Tonecas', 'AlexisTexas');
INSERT INTO MediaCenter.Amizade (idAmizade, user1, user2) VALUES(4, 'BigBoyTintz2', 'PedroMyGod');










