package org.example;

import org.example.model.Comment;
import org.example.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Post.class)
                .addAnnotatedClass(Comment.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Post post = new Post("Test post1");

            Comment comment1 = new Comment("user1");
            Comment comment2 = new Comment("user2");
            comment1.setPost(post);
            comment2.setPost(post);
            session.save(comment1);
            session.save(comment2);

            Set<Comment> commentSet = new HashSet<>();
            commentSet.add(comment1);
            commentSet.add(comment2);

            post.setComments(commentSet);

            session.save(post);

            Post postDB = session.get(Post.class, 1);
            System.out.println(postDB);

            Comment commentDB = session.get(Comment.class, 1);
            System.out.println(commentDB.getPost());
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
