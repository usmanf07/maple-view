/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocialGallery;

/**
 *
 * @author usman
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author usman
 */
public class UploadParameters {
     // required parameters
    
    private String imageBase64;
    
    // optional parameters
    private String imageName; 
    /**
     * Serializes current parameters instance to {@link LinkedHashMap} to use it in the POST-request.
     * <p>
     * This method don't add a image parameter value, because it must be in a POST-request body.
     * @return Serialized parameters as {@link LinkedHashMap}.
     * 
     * @throws RuntimeException when the required API key parameter is invalid.
     * @throws RuntimeException when the required image parameter is invalid.
     */
    public Map<String, String> toMap(File f, String name) throws FileNotFoundException, IOException {
        // api key validation
        String apiKey = "ab4decde1a0f5b117a2a57344a7ac5f3";
        if(apiKey == null || apiKey.isEmpty())
            throw new RuntimeException("The required API key parameter is invalid!");
        
        FileInputStream fileInputStreamReader = new FileInputStream(f);
        byte[] bytes = new byte[(int)f.length()];
        fileInputStreamReader.read(bytes);
        imageBase64 = new String(Base64.encodeBase64(bytes), "UTF-8");
        
        // api key validation
        if(imageBase64 == null || imageBase64.isEmpty())
            throw new RuntimeException("The required image parameter is invalid!");
        
        Map<String, String> parameters = new LinkedHashMap<>();
        
        // required API key & image parameter
        parameters.put("key", apiKey);
        parameters.put("image", imageBase64);
        imageName = name;
        // optional image name parameter
        if(imageName != null && !imageName.isEmpty())
            parameters.put("name", imageName);
        
        return parameters;
    }
    
    /**
     * A builder for the {@link UploadParameters}, provides an easy way to create it.
     */
    public static class Builder {
        
        private final UploadParameters parameters;
        
        /**
         * Building of parameters starts from this step.
         * <p>
         * You created a builder and now you can use next methods to set parameters.
         */
        public Builder() {
            this.parameters = new UploadParameters();
        }
        
        /**
         * <b>[REQUIRED]</b>
         * <p>
         * Sets the required API key parameter.
         * @param value the API key to set.
         * @return Current builder instance.
         */
//        public Builder apiKey(String value) {
//            parameters.apiKey = value;
//            return this;
//        }
        
        /**
         * <b>[REQUIRED]</b>
         * <p>
         * Sets the required image parameter as a Base64 encoded string.
         * @param value the image base64 encoded string to set.
         * @return Current builder instance.
         */
        public Builder imageBase64(String value) {
            parameters.imageBase64 = value;
            return this;
        }
        
        /**
         * <b>(OPTIONAL)</b>
         * <p>
         * Sets the optional name parameter.
         * @param value the name of an image on website.
         * @return Current builder instance.
         */
        public Builder imageName(String value) {
            parameters.imageName = value;
            return this;
        }
        
        /**
         * <b>(OPTIONAL)</b>
         * <p>
         * Sets the optional expiration time parameter.
         * @param value the expiration time instance (see info below).
         * @return Current builder instance.
         * 
         * @see ExpirationTime#fromLong(long)
         * @see ExpirationTime#fromString(String)
         */
       
        
        /**
         * Finishes a parameters building and returns builded parameters.
         * @return Builded upload parameters instance.
         */
        public UploadParameters build() {
            return parameters;
        }
        
    }
}
