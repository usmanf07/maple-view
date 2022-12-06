/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocialGallery;

/**
 *
 * @author usman
 */
public class UserImage 
{
    public int imageID;
    public String url;
    public String uploaderName;
    public UserImage(int imageID, String url, String uploaderName)
    {
        this.imageID = imageID;
        this.url = url;
        this.uploaderName = uploaderName;
    }
}
