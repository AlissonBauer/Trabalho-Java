package br.com.aula.dto;

//    import lombok.AllArgsConstructor;
//    import lombok.Data;
//
//    @Data
//    @AllArgsConstructor

public class BoletimDTO {
    private String nomeAluno;
    private String nomeCurso;
    private String nomeDisciplina;
    private double nota;
    private String status;


//    public class BoletimDTO {
//        private String nomeAluno;
//        private String nomeCurso;
//        private String nomeDisciplina;
//        private double nota;
//        private String status;
//    }


    public BoletimDTO(String nomeAluno, String nomeCurso, String nomeDisciplina, double nota, String status) {
        this.nomeAluno = nomeAluno;
        this.nomeCurso = nomeCurso;
        this.nomeDisciplina = nomeDisciplina;
        this.nota = nota;
        this.status = status;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
