package recipe;


/*
 * レシピ情報を表すモデルです
 */
public class RecipeModel {
    private String name;

    public RecipeModel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
