CREATE TABLE IF NOT EXISTS tarefas(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    descricao TEXT NOT NULL,
    data_inicio TEXT NOT NULL,
    data_alteracao TEXT,
    status INTEGER NOT NULL DEFAULT 1
    );
)