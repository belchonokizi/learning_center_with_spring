SELECT t.id as teacher_id,
t.first_name as teacher_first_name,
t.last_name as teacher_last_name,
t.work_level as teacher_level,
tp.id as pair_id,
p.name as program_name
 from teachers t join teachers_in_programs tp on t.id = tp.teacher_id
 join programs p on p.id = tp.program_id
