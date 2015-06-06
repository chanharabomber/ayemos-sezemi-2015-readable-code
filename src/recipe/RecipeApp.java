package recipe;

import java.util.Set;

public class RecipeApp {
    private Set<RecipeModel> recipes;
    private static final String LOCAL_RECIPE_FILE_PATH = "./resource/recipe-data.xml";

    public RecipeApp() {
        loadRecipes();
    }

    private void loadRecipes() {
        try {
            this.recipes = RecipeLoader.loadRecipes(LOCAL_RECIPE_FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("レシピ読み込みエラー");
        }
    }

    public void printRecipes() {
        for(RecipeModel model : recipes) {
            System.out.println(model.getName());
        }
    }

    public static void main(String[] args) {
        RecipeApp app = new RecipeApp();
        app.printRecipes();
    }
}
