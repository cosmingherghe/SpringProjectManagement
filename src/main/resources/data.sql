-- INSERT users
INSERT INTO user (user_id, first_name, email) VALUES (1, 'John', 'warton@gmail.com');
INSERT INTO user (user_id, first_name, email) VALUES (2, 'Mike', 'lanister@gmail.com');
INSERT INTO user (user_id, first_name, email) VALUES (3, 'Steve', 'Reeves@gmail.com');
INSERT INTO user (user_id, first_name, email) VALUES (4, 'Ronald', 'connor@gmail.com');
INSERT INTO user (user_id, first_name, email) VALUES (5, 'Jim', 'Sal@gmail.com');
INSERT INTO user (user_id, first_name, email) VALUES (6, 'Peter', 'henley@gmail.com');
INSERT INTO user (user_id, first_name, email) VALUES (7, 'Richard', 'carson@gmail.com');
INSERT INTO user (user_id, first_name, email) VALUES (8, 'Honor', 'miles@gmail.com');
INSERT INTO user (user_id, first_name, email) VALUES (9, 'Tony', 'roggers@gmail.com');

-- INSERT PROJECTS			
INSERT INTO project (project_id, name, stage, description) VALUES (1000, 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');
INSERT INTO project (project_id, name, stage, description) VALUES (1001, 'New Employee Budget',  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted');
INSERT INTO project (project_id, name, stage, description) VALUES (1002, 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
INSERT INTO project (project_id, name, stage, description) VALUES (1003, 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

-- INSERT PROJECT_EMPLOYEE_RELATION (Removed duplicates from video)
INSERT INTO user_project (user_id, project_id) VALUES (1,1000);
INSERT INTO user_project (user_id, project_id) VALUES (1,1001);
INSERT INTO user_project (user_id, project_id) VALUES (1,1002);
INSERT INTO user_project (user_id, project_id) VALUES (3,1000);
INSERT INTO user_project (user_id, project_id) VALUES (6,1002);
INSERT INTO user_project (user_id, project_id) VALUES (6,1003);