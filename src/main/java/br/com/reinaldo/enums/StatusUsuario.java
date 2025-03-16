package br.com.reinaldo.enums;

public enum StatusUsuario {
        BLOQUEADO(1, "Bloqueado"),
        ATIVO(2, "Ativo");

        private final int codigo;
        private final String nome;

        // Construtor da enumeração

    StatusUsuario(int codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        // Método para obter o código
        public int getCodigo() {
            return codigo;
        }

        // Método para obter o nome
        public String getNome() {
            return nome;
        }

        @Override
        public String toString() {
            return nome; // Retorna o nome quando a enumeração é convertida para String
        }
    }

