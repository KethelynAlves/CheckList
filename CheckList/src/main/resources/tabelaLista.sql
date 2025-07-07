CREATE TABLE IF NOT EXIST tarefa(
    idTarefa INTEGER PRIMARY KEY AUTOINCREMENT,
    descricao TEXT NOT NULL,
    alteracao TEXT,
    concluido INTEGER NOT NULL DEFAULT 0
    );
)