package com.example.desafiopreguntadinamica.tools;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quizzes {

    @SerializedName("response_code")
    private int responCode;
    private List<Questions> results;

    public int getResponCode() {
        return responCode;
    }

    public void setResponCode(int responCode) {
        this.responCode = responCode;
    }

    public List<Questions> getResults() {
        return results;
    }

    public void setResults(List<Questions> results) {
        this.results = results;
    }

    public class Questions{
        public String category, type, difficulty, question;
        @SerializedName("correct_answer")
        public String corrAnsw;
        @SerializedName("incorrect_answers")
        public String[] incoAnsw;
    }
}
