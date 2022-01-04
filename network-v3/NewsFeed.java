import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * The NewsFeed class stores news posts for the news feed in a
 * social network application.
 * 
 * Display of the posts is currently simulated by printing the
 * details to the terminal. (Later, this should display in a browser.)
 * 
 * This version does not save the data to disk, and it does not
 * provide any search or ordering functions.
 * 
 * @author Ruhuan Liao
 * @version 1.0
 */
public class NewsFeed implements Serializable
{
    private ArrayList<Post> posts;
    private ArrayList<Post> removedPosts;

    /**
     * Construct an empty news feed.
     */
    public NewsFeed()
    {
        posts = new ArrayList<>();
        removedPosts = new ArrayList<>();
    }

    /**
     * Add a post to the news feed.
     * 
     * @param post  The post to be added.
     */
    public void addPost(Post post)
    {
        posts.add(post);
    }
    
    public void removePost(Post post){
        posts.remove(post);
        removedPosts.add(post);
    }
    
    public void restorePosts(){
        posts.addAll(removedPosts);
        removedPosts.clear();
    }
    
    public void saveToFile() throws ClassNotFoundException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("Posts.bin");
            oos = new ObjectOutputStream(oos);
            for (Post post: posts){
                oos.writeObject(post);
            }
            fos.close();
            oos.close();
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public void loadFrromFile() throws ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("posts.bin");
            ois = new ObjectInputStream(fis);
            while (true){
                Post post = (Post)ois.readObject();
                if (!posts.contains(post))
                    posts.add(post);
            }
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        try{
            ois.close();
            fis.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
    }

    /**
     * Show the news feed. Currently: print the news feed details
     * to the terminal. (To do: replace this later with display
     * in web browser.)
     */
    public void show()
    {
        // display all posts
        for(Post post : posts) {
            if(!post.isHidden()){
            post.display();
            System.out.println();   // empty line between posts
            }
        }
    }
    
    
}
