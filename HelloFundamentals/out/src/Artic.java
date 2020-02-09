import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Artic {

    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void setContent(String param) {
            this.content = param;
        }

        public void changeAuthor(String param) {
            this.author = param;
        }

        public void rename(String param) {
            this.title = param;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s ", this.title, this.content, this.author);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split(", ");

            String title = input[0];
            String content = input[1];
            String author = input[2];

            Article article = new Article(title, content, author);

            articles.add(article);
        }
        String criteria = scanner.nextLine();

        if (criteria.equals("title")){
            articles.sort((f,s) -> f.getTitle().compareTo(s.getTitle()));
        }else if (criteria.equals("content")){
            articles.sort((f,s) -> f.getContent().compareTo(s.getContent()));
        }else {
            articles.sort((f,s) -> f.getAuthor().compareTo(s.getAuthor()));
        }

        for (Article article : articles) {
            System.out.println(article.toString());
        }
    }
}
