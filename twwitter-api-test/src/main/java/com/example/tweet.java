package com.example;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
 
public class tweet
{
    public static void main(String ar[]) throws TwitterException
    {
        Twitter twitter;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        //Aquí deberéis sustituir vuestras key, secret, token y tokenSecret.
        //Estas son las claves de mi cuenta @SuarezDeveloper
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey("K9LOlayaRsekfnmmcseWry8ge")
            .setOAuthConsumerSecret("YgX0zzjzXgyyg3F9CwPMdpo6fHgY4bmbserE1QIGMX5Nul9xV4")
            .setOAuthAccessToken("79032852-EjO6Og4fsyVDWnfI4QwfrGwL5twdW7nuo3Nx4i45r")
            .setOAuthAccessTokenSecret("XZtsDkHBClph2qQ6afCjhOefPJXtz81NduXzegpYslIWv");
        twitter = new TwitterFactory(cb.build()).getInstance();
 
        //Recuperar listado de ultimos tweets escritos
        //El paging sirve para decir el número máx de tweets que quieres recuperar
        Paging pagina = new Paging();
        pagina.setCount(50);
 
        //Recupera como máx 50 tweets escritos por tí
        ResponseList listado = twitter.getUserTimeline(pagina);
        for (int i = 0; i < listado.size(); i++)
            System.out.println(listado.get(i).getText());
 
        //Recupera como máx los ultimos 50 tweets de tus tablon de novedades
        listado = twitter.getHomeTimeline(pagina);
        for (int i = 0; i < listado.size(); i++)
            System.out.println(listado.get(i).getText());
 
        //Actualizar tu estado
        Status tweetEscrito = twitter.updateStatus("Este tweet ha sido mandado desde el manual de https://suarezdeveloper.wordpress.com/2012/04/12/como-twittear-con-java/ #SuarezDeveloperTwitter");
    }
}
