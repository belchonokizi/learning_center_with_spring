SELECT pr.id as program_id,
pr.name as program_name
 FROM programs pr WHERE pr.id = ?;