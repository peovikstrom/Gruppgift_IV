INSERT INTO theatre (name, row, col) VALUES
('Salong 1', '10','10'),
('Salong 2', '10', '10'),
('Salong 3', '10', '10'),
('Salong 4', '10', '10');

INSERT INTO movie (title, description, uri_poster) VALUES
('Scarface', 'In Miami in 1980, a determined Cuban immigrant takes over a drug cartel and succumbs to greed.','/img/scarface.jpg'),
('The Terminator', 'A seemingly indestructible android is sent from 2029 to 1984 to assassinate a waitress, whose unborn son will lead humanity in a war against the machines, while a soldier from that war is sent to protect her at all costs.','/img/terminator.jpg'),
('The Legend of Tarzan', 'Tarzan, having acclimated to life in London, is called back to his former home in the jungle to investigate the activities at a mining encampment.','/img/tarzan.jpg'),
('Hitta Nemo', 'After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.','/img/hittaNemo.jpg');

INSERT INTO show (movie_id, theatre_id, start, stop) VALUES
(1,1,'2018-01-01 12:00:00', '2018-01-01 14:00:00'),
(2,2,'2018-01-01 12:00:00', '2018-01-01 14:00:00'),
(3,3,'2018-01-01 12:00:00', '2018-01-01 14:00:00'),
(4,4,'2018-01-01 12:00:00', '2018-01-01 14:00:00');

INSERT INTO customer (name, adress, phone_number) VALUES
('Joe Stalin', 'Kreml', '123-456'),
('Bubba Rosevelt', 'Pearl Harbor', '678-123');

INSERT INTO ticket (customer_id, show_id, seat_row, seat_col) VALUES
(1,1,1,1),
(2,2,1,1),
(1,2,1,2),
(1,3,1,1);
