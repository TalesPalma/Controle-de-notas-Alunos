package org.example.Aluno;

public class Aluno {
    private String nome;
    private int turma,nota;
    private Boolean estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Aluno() {
    }

    public Aluno(String nome, int turma, int nota, Boolean estado) {
        this.nome = nome;
        this.turma = turma;
        this.nota = nota;
        this.estado = estado;
    }
}
