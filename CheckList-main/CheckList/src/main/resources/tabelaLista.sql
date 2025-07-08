CREATE TABLE IF NOT EXIST tarefa(
    idTarefa INTEGER PRIMARY KEY AUTOINCREMENT,
    descricao TEXT NOT NULL,
    data_inicio TEXT NOT NULL,
    data_alteracao TEXT,
    concluido INTEGER NOT NULL DEFAULT 0
    );
)