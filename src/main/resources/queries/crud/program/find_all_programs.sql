SELECT pr.id as program_id,
pr.name as program_name,
m.id as module_id,
m.name as module_name,
m.duration as module_duration
 FROM programs pr JOIN modules m
 ON pr.id = m.program_id;