package Model;

public class Dictionary {
    private String keyword;
    private String description;
    private String word_type;

    public Dictionary(String keyword, String description, String word_type) {
        this.keyword = keyword;
        this.description = description;
        this.word_type = word_type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWord_type() {
        return word_type;
    }

    public void setWord_type(String word_type) {
        this.word_type = word_type;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "keyword='" + keyword + '\'' +
                ", description='" + description + '\'' +
                ", word_type='" + word_type + '\'' +
                '}';
    }
}
