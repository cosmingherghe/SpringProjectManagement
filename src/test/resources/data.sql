-- INSERT EMPLOYEES			
insert into employee (employee_id, first_name, email) values (nextval('employee_seq'), 'John','warton@gmail.com');
insert into employee (employee_id, first_name, email) values (nextval('employee_seq'), 'Mike', 'lanister@gmail.com');
insert into employee (employee_id, first_name, email) values (nextval('employee_seq'), 'Steve', 'Reeves@gmail.com');
insert into employee (employee_id, first_name, email) values (nextval('employee_seq'), 'Ronald', 'connor@gmail.com');
insert into employee (employee_id, first_name, email) values (nextval('employee_seq'), 'Jim', 'Sal@gmail.com');
insert into employee (employee_id, first_name, email) values (nextval('employee_seq'), 'Peter', 'henley@gmail.com');
insert into employee (employee_id, first_name, email) values (nextval('employee_seq'), 'Richard', 'carson@gmail.com');
insert into employee (employee_id, first_name, email) values (nextval('employee_seq'), 'Honor', 'miles@gmail.com');
insert into employee (employee_id, first_name, email) values (nextval('employee_seq'), 'Tony', 'roggers@gmail.com');

-- INSERT PROJECTS			
insert into project (project_id, name, stage, description, start_date, end_date) values (nextval('project_seq'), 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production', '2020-03-30', '2020-06-04');
insert into project (project_id, name, stage, description, start_date, end_date) values (nextval('project_seq'), 'New Employee Budget',  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted', '2020-06-04', '2020-08-14');
insert into project (project_id, name, stage, description, start_date, end_date) values (nextval('project_seq'), 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed', '2020-08-01','2020-09-14');
insert into project (project_id, name, stage, description, start_date, end_date) values (nextval('project_seq'), 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation', '2020-09-25', '2020-11-30');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='John' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='John' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='John' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Steve' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='John' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='John' AND p.name = 'Improve Intranet Security');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Peter' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Peter' AND p.name = 'Improve Intranet Security');