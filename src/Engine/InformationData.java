/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine;

/**
 *
 * @author Sora
 */
public class InformationData {
    private String code, title, episodes, year, rate, producers, genre, description;
    
    public InformationData(){
        
    }
    public InformationData(String code, String title, String episodes, String year, String producers, String genre, String rate, String description){
        this.code = code;
        this.title = title;
        this.episodes = episodes;
        this.year = year;
        this.rate = rate;
        this.producers = producers;
        this.genre = genre;
        this.description = description;
    }
    
    public final void setCode(String code){
        this.code = code;
    }
    
    public final String getCode(){
        return code;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setEpisodes(String episodes){
        this.episodes = episodes;
    }
    
    public String getEpisodes(){
        return episodes;
    }
    
    public void setYear(String year){
        this.year = year;
    }
    
    public String getYear(){
        return year;
    }
    
    public void setProducers(String producers){
        this.producers = producers;
    }
    
    public String getProducers(){
        return producers;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public void setRate(String rate){
        this.rate = rate;
    }
    
    public String getRate(){
        return rate;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }
}
