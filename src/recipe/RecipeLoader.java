package recipe;

import java.util.Set;
import java.util.HashSet;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException; 
import javax.xml.parsers.ParserConfigurationException;

/*
 * レシピデータを読み込み、パースしてRecipeModelオブジェクトに変換する
 * ユーティリティクラスです
 */
public class RecipeLoader {
    public static Set<RecipeModel> loadRecipes(String path) 
        throws ParserConfigurationException, SAXException, IOException {
        /* TODO: ここでpathをみて、{http,ftp}://... という
         * 形式になっていたらRecipeLoader.fetchRemoteRecipesを、
         * そうでなかったらRecipeLoader.loadLocalRecipesを呼ぶようにしたい。
         * 今回はレシピファイルがローカルにあるので、実装せず
         */
        if(path == null || path.equals(""))
            return null;
        else 
            return loadRecipesFromLocalXML(path);
    }

    private static Set<RecipeModel> fetchRemoteRecipes(String url) {
        // 今回は使わない。
        return null;
    }

    private static Set<RecipeModel> loadRecipesFromLocalXML(String path) 
        throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory =
            DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Node root = builder.parse(path);
        NodeList children = root.getChildNodes(); 

        /*
         * TODO: 多分ここのXMLの読み込みがまだバグってます
         */
        Set<RecipeModel> recipeModels = new HashSet<RecipeModel>();
        for (int i = 0; i < children.getLength(); i++) {
            Node recipeNode = children.item(i);
            // Node nameNode = ...
            // RecipeModel recipeModel = new RecipeModel(nameNode.getNodeValue());
            // recipeModels.add(recipeModel);
        }

        return recipeModels;
    }
}
