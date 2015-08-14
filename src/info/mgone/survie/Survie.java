package info.mgone.survie;


import info.mgone.survie.agent.Agent;
import info.mgone.survie.antixray.BreakListener;
import info.mgone.survie.banquier.Banquier;
import info.mgone.survie.banquier.Slotp;
import info.mgone.survie.chat.ChatListener;
import info.mgone.survie.chat.antitab;
import info.mgone.survie.crate.Anim;
import info.mgone.survie.crate.LootChest;
import info.mgone.survie.gui.Aide;
import info.mgone.survie.gui.Menu;
import info.mgone.survie.gui.Pmenu;
import info.mgone.survie.gui.Png;
import info.mgone.survie.gui.armurier.Armes;
import info.mgone.survie.gui.armurier.Armures;
import info.mgone.survie.gui.armurier.Armurier;
import info.mgone.survie.gui.armurier.Haches;
import info.mgone.survie.gui.armurier.job.Recruteur;
import info.mgone.survie.gui.marchant.Bloc1;
import info.mgone.survie.gui.marchant.Bloc2;
import info.mgone.survie.gui.marchant.Marchant;
import info.mgone.survie.gui.marchant.Minerais;
import info.mgone.survie.gui.marchant.Plantes;
import info.mgone.survie.gui.marchant.RedstoneShop;
import info.mgone.survie.gui.marchant.Rush;
import info.mgone.survie.hdv.Troqueur;
import info.mgone.survie.instructeur.Baston;
import info.mgone.survie.instructeur.Grades;
import info.mgone.survie.instructeur.Instructeur;
import info.mgone.survie.instructeur.Mana;
import info.mgone.survie.instructeur.PvMax;
import info.mgone.survie.instructeur.Speed;
import info.mgone.survie.noob.NoobPvP;
import info.mgone.survie.particles.ParticleCreator;
import info.mgone.survie.skill.KillSkill;
import info.mgone.survie.skill.Skill;
import info.mgone.survie.skill.SkillSave;
import info.mgone.survie.stats.Lag;
import info.mgone.survie.stats.Stats;
import info.mgone.survie.weapon.TomaHawk;
import info.mgone.survie.weapon.WeapeonLvL;
//import io.netty.buffer.Unpooled;












import info.mgone.survie.xpbank.ExpBottle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.scheduler.BukkitScheduler;








import org.tyrannyofheaven.bukkit.zPermissions.ZPermissionsService;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;




public class Survie extends org.bukkit.plugin.java.JavaPlugin implements org.bukkit.event.Listener
{
	
	  BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	  public static HashMap<String, String> pubeur = new HashMap<String, String>();
	  public static HashMap<String, Location> cheateurkickforfly = new HashMap<String, Location>();
	  
	  WorldGuardPlugin WG;
	  public static Permission permission = null;
	  public static Economy eco = null;
	  public static Chat chat = null;
	  public static Plugin plugin;
	  public static ZPermissionsService service = null;

	  
	
  public void onEnable()
  {
    getLogger().info("Status: Survie by Mgone ENABLED");
    plugin = this;
    RemoveH();
    RegisterAllEvents();
    WG = getWorldGuard();
    setupPermissions();
    setupEconomy();
    setupChat();
    getConfig().options().copyDefaults(true);
    saveDefaultConfig();
    reloadConfig();
    AllGui();
    Png.SpawnVillager();
    changebcaune();
    Glow.register();

    MySQL.openConnection();
    if (MySQL.con == null) {
        System.out.println("MySQL-Error: Willobby is gonna shutdown because it can't connect to the database.");
        return;
     }
    MySQL.createStatement("CREATE TABLE IF NOT EXISTS skills (id INTEGER(11) not null AUTO_INCREMENT, player VARCHAR(16) , uuid VARCHAR(36), skill INTEGER, PRIMARY KEY (id))");
    MySQL.createStatement("CREATE TABLE IF NOT EXISTS playerstats (id INTEGER(11) not null AUTO_INCREMENT, player VARCHAR(16), uuid VARCHAR(36), timep DOUBLE, joinp INTEGER, firsjoin DOUBLE, lastjoin DOUBLE, lastleave DOUBLE, PRIMARY KEY (id))");
    MySQL.createStatement("CREATE TABLE IF NOT EXISTS noobprotect (id INTEGER(11) not null AUTO_INCREMENT, player VARCHAR(16), uuid VARCHAR(36), PRIMARY KEY (id))");
    MySQL.createStatement("CREATE TABLE IF NOT EXISTS ipcheck (id INTEGER(11) not null AUTO_INCREMENT, player VARCHAR(16), uuid VARCHAR(36), ip VARCHAR(36), PRIMARY KEY (id))");
    MySQL.createStatement("CREATE TABLE IF NOT EXISTS lootchest (id INTEGER(11) not null AUTO_INCREMENT, player VARCHAR(16), uuid VARCHAR(36), PRIMARY KEY (id))");
    MySQL.createStatement("CREATE TABLE IF NOT EXISTS perm (id INTEGER(11) not null AUTO_INCREMENT, player VARCHAR(16), uuid VARCHAR(36), chestslot INTEGER, chestender INTEGER, chestcmd INTEGER, pv INTEGER, speed INTEGER, baston INTEGER, PRIMARY KEY (id))");
    
    MySQL.createStatement("CREATE TABLE IF NOT EXISTS blocstats (id INTEGER(11) not null AUTO_INCREMENT, player VARCHAR(16) , uuid VARCHAR(36), stone INTEGER, gold INTEGER, iron INTEGER,"
    		+ " coal INTEGER, lapis INTEGER, diamond INTEGER, redstone INTEGER, emerald INTEGER, gravel INTEGER, quartz INTEGER, nether INTEGER, PRIMARY KEY (id))");
    
    MySQL.createStatement("CREATE TABLE IF NOT EXISTS votegive (id INTEGER(11) not null AUTO_INCREMENT, name VARCHAR(16), PRIMARY KEY (id))");
    
    SkillSave.SkillTask();
    Stats.StatsTask();
    NoobPvP.NoobTask();
    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
    new ParticleCreator().runTaskTimer(this, 20, 1);
    Anim.AnimChest();
    LootChest.ResetTimer();
    DifTask.Astuces();
    ExpBottle.ExpBanque();
    BreakListener.StatsTaskBlocks();
    
   //MySQL.querySQL("SELECT * INTO DUMPFILE 'C:\\\\Users\\\\ghofrane\\\\Desktop\\\\survie\\\\result.sql' FROM skills"); 

    
    antitab.initPacketListener();
    
    
  }
  
  public void onDisable()
  {
    getLogger().info("Status: Survie by Mgone DISABLED");
    RemoveH();
    SkillSave.SkillSaveReboot();
    Stats.StatsRebbot();
    Glow.unregister();
  }
  
  
  
  
  public void reloadConfig()
  {
    super.reloadConfig();
  }
  
//instance
public static Plugin getPluginInstance(){
	    return plugin;
	}
  
  private boolean setupEconomy() {
	    if (getServer().getPluginManager().getPlugin("Vault") == null) {
	      return false;
	    }
	    RegisteredServiceProvider<Economy> rsp = getServer()
	      .getServicesManager().getRegistration(Economy.class);
	    if (rsp == null) {
	      return false;
	    }
	    eco = rsp.getProvider();
	    return eco != null;
	  }
  
	private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        permission = rsp.getProvider();
        return permission != null;
    }
  

  
   public static WorldGuardPlugin getWorldGuard() {
	   Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
	    
	   // WorldGuard may not be loaded
	   if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	   return null; // Maybe you want throw an exception instead
	   }
	    
	   return (WorldGuardPlugin) plugin;
	   }
   
   
 //chat
 	private boolean setupChat() {
 	        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
 	        if (chatProvider != null) {
 	            chat = chatProvider.getProvider();
 	        }

 	        return (chat != null);
 	    }

 
 //tout les class
	  public void RegisterAllEvents() {
		  getServer().getPluginManager().registerEvents(this, this);
		  getServer().getPluginManager().registerEvents(new Menu(), this);
		  getServer().getPluginManager().registerEvents(new ParticleCreator(), this);
		  getServer().getPluginManager().registerEvents(new LootChest(), this);
		  getServer().getPluginManager().registerEvents(new ChatListener(), this);
		  getServer().getPluginManager().registerEvents(new Pmenu(), this);
		  getServer().getPluginManager().registerEvents(new Marchant(), this);
		  getServer().getPluginManager().registerEvents(new Bloc1(), this);
		  getServer().getPluginManager().registerEvents(new Bloc2(), this);
		  getServer().getPluginManager().registerEvents(new Plantes(), this);
		  getServer().getPluginManager().registerEvents(new RedstoneShop(), this);
		  getServer().getPluginManager().registerEvents(new Minerais(), this);
		  getServer().getPluginManager().registerEvents(new Rush(), this);
		  getServer().getPluginManager().registerEvents(new Png(), this);
		  getServer().getPluginManager().registerEvents(new LoginPlayer(), this);
		  getServer().getPluginManager().registerEvents(new Recruteur(), this);
		  getServer().getPluginManager().registerEvents(new Aide(), this);
		  getServer().getPluginManager().registerEvents(new Agent(), this);
		  getServer().getPluginManager().registerEvents(new Banquier(), this);
		  getServer().getPluginManager().registerEvents(new Slotp(), this);
		  getServer().getPluginManager().registerEvents(new Troqueur(), this);
		  
		  getServer().getPluginManager().registerEvents(new WeapeonLvL(), this);
		  getServer().getPluginManager().registerEvents(new TomaHawk(), this);
		  
		  getServer().getPluginManager().registerEvents(new Armurier(), this);
		  getServer().getPluginManager().registerEvents(new Armes(), this);
		  getServer().getPluginManager().registerEvents(new Haches(), this);
		  getServer().getPluginManager().registerEvents(new Armures(), this);
		  
		  getServer().getPluginManager().registerEvents(new KillSkill(), this);
		  getServer().getPluginManager().registerEvents(new NoobPvP(), this);
		  
		  getServer().getPluginManager().registerEvents(new Instructeur(), this);
		  getServer().getPluginManager().registerEvents(new Grades(), this);
		  getServer().getPluginManager().registerEvents(new Speed(), this);
		  getServer().getPluginManager().registerEvents(new PvMax(), this);
		  getServer().getPluginManager().registerEvents(new Mana(), this);
		  getServer().getPluginManager().registerEvents(new Baston(), this);
		  getServer().getPluginManager().registerEvents(new TntPistol(), this);
		  getServer().getPluginManager().registerEvents(new Boussole(), this);
		  getServer().getPluginManager().registerEvents(new ExpBottle(), this);
		  getServer().getPluginManager().registerEvents(new BreakListener(), this);
		  
	  }
  


	//lancement des gui
	  public void AllGui(){
		  Menu.GUImenu = Bukkit.createInventory(null, 36, "§5\u2663 Navigateur \u2663");
		  Marchant.GUImarchant = Bukkit.createInventory(null, 9, "§5\u2663 Marchand général \u2663");
		  Bloc1.GUIblock1 = Bukkit.createInventory(null, 45, "§6\u2663 Blocks de construction \u2663");
		  Bloc2.GUIblock2 = Bukkit.createInventory(null, 45, "§6\u2663 Blocks de décoration \u2663");
		  Plantes.GUIplantes = Bukkit.createInventory(null, 45, "§6\u2663 Plantes \u2663");
		  RedstoneShop.GUIredstone = Bukkit.createInventory(null, 27, "§6\u2663 Redstone \u2663");
		  Minerais.GUImin = Bukkit.createInventory(null, 27, "§6\u2663 Minerais et Potions \u2663");
		  Rush.GUIrush = Bukkit.createInventory(null, 18, "§5\u2663 Rush Items \u2663");
		  Armurier.GUIarmurier = Bukkit.createInventory(null, 9, "§6\u2663 Armurier \u2663");
		  Armes.GUIarme = Bukkit.createInventory(null, 45, "§6\u2663 Epées \u2663");
		  Haches.GUIhache = Bukkit.createInventory(null, 18, "§6\u2663 Hache TomaHawk \u2663");
		  Armures.GUIarmure = Bukkit.createInventory(null, 18, "§6\u2663 Armures \u2663");
		  Instructeur.GUIinstruc = Bukkit.createInventory(null, 9, "§5\u2663 Instructeur \u2663");
		  Troqueur.GUItroque = Bukkit.createInventory(null, 27, "§5\u2663 Troque et Enchère \u2663");
		  
	  }
  

@SuppressWarnings("deprecation")
public boolean onCommand(org.bukkit.command.CommandSender sender, Command cmd, String label, String[] args)
  {

      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        
        
        if (cmd.getName().equalsIgnoreCase("sreload")) {
        	
        	if(player.hasPermission("s.reload")) {
        		reloadConfig();
            player.sendMessage(ChatColor.GOLD + "[Survie] " + ChatColor.GRAY + "You have reloaded config."); }
        	
        	else  player.sendMessage(ChatColor.GOLD + "[Survie] " + ChatColor.GRAY + "Vous n'avez pas la permission ;).");
        	
          }
  
   
    if (cmd.getName().equalsIgnoreCase("plugin") || cmd.getName().equalsIgnoreCase("plugins") || cmd.getName().equalsIgnoreCase("pl"))
    {
      player.sendMessage("Plugins (1):" + ChatColor.GREEN + " CraftZone");
    }
    
    
    
    if (cmd.getName().equalsIgnoreCase("help") || cmd.getName().equalsIgnoreCase("aide"))
    { 
    	if (args.length == 0) {
        player.sendMessage(ChatColor.GOLD + "======================================= \n" +
         "§b/s: §fNavigateur pour se téléporter.\n"+
         "§a/p: §fVoir vos stats.\n"+
         "§b/tm: §fGérer votre team.\n"+
         "§a/claim: §fGérer vos terrains(claims).\n"+
         "§b/home: §fSe téléporter à votre home.\n"+
         "§a/sethome: §fPoser votre home.\n"+
         "§b/delhome: §fSupprimer votre home.\n"+
         "§a/icon: §fListe des icones disponibles.\n"+
         "§b/aide tp: §fAide téléportation entre joueurs.\n"+
         "§a/pay <joueur> <somme>: §fEnvoyer de l'argent.\n"+
         "§b/hdv: §fAide hotel de vente.\n" +
         "§a/msg [joueur] message: §fenvoyer un message privé.\n" +
         "§b/list: §fPour afficher la liste des joueurs connectés.\n" +
         "§a/spawn: §fpour retourner au spawn.\n" +
         "§b/lobby: §fRetourner au lobby(spawn principal).\n" +
          ChatColor.GOLD + "=======================================");
        
    	} else if (args.length == 1)
        {
        
        	    if (args[0].equalsIgnoreCase("acheter"))
        	    {
        	  
        	        player.sendMessage("=======================================\n" + 
        	          "Cliquez sur l'émeraude du troqueur\n" + 
        	          "pour afficher la liste des items en vente.\n" +
        	          "Ensuite vous pouvez changer les pages, rechercher..\n" +
        	          "pour acheter faite un double clic sur l'item désirer \n" +
        	          "=======================================");
        	      }
        	    
        	    
        	    else  if (args[0].equalsIgnoreCase("vendre"))
        	    {
        	  
        	        player.sendMessage("=======================================\n" + 
        	          "Cliquez sur l'émeraude du troqueur:\n" + 
        	          "puis déposez les items que vous voulez vendre sur l'entonnoir.\n" +
        	          "Ensuite indiquez le prix et la quantité sur le panneau qui apparaitra\n" +
        	          "=======================================");
        	      }
        	    
        	    
        	    else  if (args[0].equalsIgnoreCase("mail"))
        	    {
        	        player.sendMessage("=======================================\n" + 
        	          "Lorsque vous vendez un item ou vous achetez un, il sera placé :\n" + 
        	          "dans votre boite aux lettres. Vous pouvez le récuperer en\n" +
        	          "cliquant dessus. vous pouvez aussi gérer vos items mis en vente\n" +
        	          "depuis votre boite aux lettres \n" +
        	          "=======================================");
        	      }
        	    
        	    else  if (args[0].equalsIgnoreCase("tp"))
        	    {
        	        player.sendMessage("=======================================\n" + 
        	          "- /tpa [pseudo] : Envoyer une requête pour se téléporter à un joueur.\n" + 
        	          "- /tpahere [pseudo] : Envoyer une requête pour téléporter un joueur à votre position.\n" +
        	          "- /tpaccept : Accepter une demande de téléportation.\n" +
        	          "- /tpdeny : Refuser une demande de téléportation.\n" +
        	          "=======================================");
        	      }
        
        	    else { player.sendMessage("Commande inconnu! Tapez '/help ou /aide ' pour plus d'info."); }
        	    
        }else { player.sendMessage("Commande inconnu! Tapez '/help ou /aide' pour plus d'info."); }
        
      }
    
    	if (cmd.getName().equalsIgnoreCase("hdv"))
        {
      
            player.sendMessage(ChatColor.GOLD + "=======================================\n" + 
              ChatColor.RED + "- Hotel de vente aide :\n" + 
              ChatColor.GREEN + "/aide acheter " + ChatColor.RESET + "Acheter un item\n" +
              ChatColor.GREEN + "/aide vendre " + ChatColor.RESET + "Vendre un item\n" +
              ChatColor.GREEN + "/aide mail " + ChatColor.RESET + "Récuperer vos achats/ventes \n" +
              ChatColor.GOLD + "=======================================");
          }
    
    
    if (cmd.getName().equalsIgnoreCase("icon"))
    {

        
        player.sendMessage(ChatColor.GOLD + "=======================================\n" + 
          ChatColor.RED + "- liste des icons diponible :\n" + 
          ChatColor.GREEN + "- :) ☺ , :-) ☺ , :( ☹ , :-( ☹ , ;) ツ , ;-) ツ , avion* ✈\n" +
          ChatColor.GREEN + ":love: ♥ , ok* ✔ , <3 �?� , carreau* ♦ , trefle* ♣ , pique* ♠\n" +
          ChatColor.GREEN + "coeur* ♥ , femme* ♀ , homme* ♂ , music* ♪♫♫♪ , no* ✖ , tel* ☎\n" +
          ChatColor.GREEN + "soleil* ☼ , lune* ☾ , fleur* ✿ , nuage* �?\n" +
          ChatColor.GOLD + "=======================================");
      }
    
    
    if (cmd.getName().equalsIgnoreCase("vote"))
    {

    	player.sendMessage("§b§lSi vous tenez à §c§lC§e§lr§a§la§b§lf§1§lt§d§lZ§8§lo§6§ln§5§le §b§l Votez chaque 24 heures\n"
    	+ "§a§l==>http://craftzone.fr/vote/\n"+
    		"§6Les votes et les achats aides le serveur à survivre");

    }
    
    
    if (cmd.getName().equalsIgnoreCase("dvote"))
    {
    	if(player.hasPermission("use.dvote"))
        Bukkit.getServer().broadcastMessage("§d[" + player.getName() + "] §b§ln'oubliez pas de voter pour §c§lC§e§lr§a§la§b§lf§1§lt§d§lZ§8§lo§6§ln§5§le §b§l chaque 24 heures\n"
    	+ "§a§l==>http://craftzone.fr/vote/");
        else player.sendMessage( ChatColor.RED + "Vous n'avez pas la permission!");
    }
    
    

    if (cmd.getName().equalsIgnoreCase("pub"))
    { 
    	if(player.hasPermission("warn.pub")) {

    	if (args.length == 0) {	
    		
        	player.sendMessage("§6joueurs averti et mute pour pub §f(" + pubeur.size() + "):");
        	
        	for( Iterator<String> i = pubeur.keySet().iterator(); i.hasNext();){
        		String key = i.next();
        		String  pub = pubeur.get(key); 
        		player.sendMessage("§a- " + key + ": §f" + pub );
        		
            } player.sendMessage("§f==>/pub help : pour la liste des commandes");
    	
    	} else if (args.length == 2) {
    		
    		
    		
     if (args[0].equalsIgnoreCase("remove")) {

    	 if(player.hasPermission("remove.pub")) {
	OfflinePlayer player2 = Bukkit.getOfflinePlayer(args[1]);
    
    if(args[1].equals("all")) { pubeur.clear(); player.sendMessage("§eliste supprimée"); return false; }
    
  if (pubeur.containsKey(player2.getName())) { pubeur.remove(player2.getName()); player.sendMessage("§ajoueur supprimé!");} else player.sendMessage("§cjoueur invalide!");
    	 } else player.sendMessage("§4Vous n'avez pas la permission!"); //fin perm remove
    	 
     }  else player.sendMessage("Usage: /pub, /pub remove <joueur>, /pub remove all");	//fin remove
	
    		
    	} else player.sendMessage("Usage: /pub, /pub remove <joueur>, /pub remove all");	//fin lenght = 1 else =2
    	
    	
    	
    	} else player.sendMessage("§4Vous n'avez pas la permission!");
    }
    
    
    if (cmd.getName().equalsIgnoreCase("resetkdr"))
    {
    	if(player.isOp()) {
    	MySQL.createStatement("UPDATE sc_players SET neutral_kills=0, rival_kills=0, civilian_kills=0, deaths=0"); player.sendMessage("§7KDR rest!");
    	MySQL.createStatement("DELETE FROM sc_kills"); player.sendMessage("§7Kills supprimés!");
    	}
    	
    }
    
    if (cmd.getName().equalsIgnoreCase("p"))
    {
    	player.openInventory(Pmenu.displayPmenu(player,false));
    }

    
    if (cmd.getName().equalsIgnoreCase("s"))
    {
    	player.openInventory(Menu.displayMenu());
    }
    
    if (cmd.getName().equalsIgnoreCase("menu"))
    {
    	player.openInventory(Menu.displayMenu());
    }
    
    if (cmd.getName().equalsIgnoreCase("banque") || cmd.getName().equalsIgnoreCase("b"))
    {
    	if(player.hasPermission("betterenderchest.command.openinv"))
    	player.performCommand("bec openinv");
    	else player.sendMessage("§cVous n'avez pas la permission! §6Passez voir le banquier pour en savoir plus.");
    }

    
    if (cmd.getName().equalsIgnoreCase("job"))
    {
    	player.performCommand("jobs stats");
    }
    
    if (cmd.getName().equalsIgnoreCase("skill"))
    {
    	if(args.length == 0) player.sendMessage("§a[Skill]: §f"+ LoginPlayer.skills.get(player.getName()) + " §7points de compétence.");
    	else if(args.length == 1) { if(!player.hasPermission("survie.op")) return false;
    		OfflinePlayer pf = Bukkit.getOfflinePlayer(args[0]);
    		if(pf == null) { player.sendMessage("§cJoueur invalide!"); return false; }
    		if(!Skill.HaveSkillOffline(pf)) { player.sendMessage("§cJoueur introuvable!"); return false; }
    		if(pf.isOnline()) player.sendMessage("§a[Skill] §6("+ args[0] +"): §f"+ LoginPlayer.skills.get(pf.getName()) + " §7points de compétence.");
    		else player.sendMessage("§a[Skill] §6("+ args[0] +"): §f"+ Skill.getSkillOffline(pf) + " §7points de compétence.");
    	}
    }
    
    
    if (cmd.getName().equalsIgnoreCase("stats"))
    {
    	if(args.length == 0) player.sendMessage(Stats.GetStats(player.getName()));
    	else if(args.length == 1) { if(player.hasPermission("survie.op")) player.sendMessage(Stats.GetStats(args[0]));
    	BreakListener.SendStats(player,args[0]);
    	}
    }
    
    
    if (cmd.getName().equalsIgnoreCase("pvp"))
    {
    	NoobPvP.CommandNoob(player);
    }
    
    
    if (cmd.getName().equalsIgnoreCase("pvpon"))
    {
    	NoobPvP.CommandPVPon(player);
    }
    
    
    
    if (cmd.getName().equalsIgnoreCase("fupdate")) {
    	if (player.hasPermission("use.fupdate")) {
    		utility.ForceUpdate(args[0], args[1]);
    	}
    }
    
    
    
    
    
	if (cmd.getName().equalsIgnoreCase("kickfly")) {
		if (player.hasPermission("warn.cheat")) {

			if (args.length == 0) {

				player.sendMessage("§6joueurs suspect de cheat §f(kickfly) §6("+ cheateurkickforfly.size() + "):");

				for (Iterator<String> i = cheateurkickforfly.keySet().iterator(); i.hasNext();) {
					String key = (String) i.next();
					int lx = cheateurkickforfly.get(key).getBlockX();
					int ly = cheateurkickforfly.get(key).getBlockY();
					int lz = cheateurkickforfly.get(key).getBlockZ();
					player.sendMessage("§a- " + key + ": §fX=" + lx+ ",Y=" + ly + ",Z=" + lz);

				}
				player.sendMessage("§f==>/kickfly help : pour la liste des commandes");

			} else if (args.length == 2) {

				if (args[0].equalsIgnoreCase("remove")) {

					if (player.hasPermission("remove.cheat")) {

						OfflinePlayer player2 = Bukkit.getOfflinePlayer(args[1]);

						if (args[1].equals("all")) {
							cheateurkickforfly.clear();
							player.sendMessage("§eliste supprimée");
							return false;
						}

						if (cheateurkickforfly.containsKey(player2.getName())) {
							cheateurkickforfly.remove(player2.getName());
							player.sendMessage("§ajoueur supprimé!");
						} else
							player.sendMessage("§cjoueur invalide!");
					} else
						player.sendMessage("§4Vous n'avez pas la permission!");

				} else
					player.sendMessage("Usage: /kickfly, /kickfly remove <joueur>, /kickfly remove all");

			} else
				player.sendMessage("Usage: /kickfly, /kickfly remove <joueur>, /kickfly remove all");

		} else
			player.sendMessage("§4Vous n'avez pas la permission!");
	}
    
    
    
			if (cmd.getName().equalsIgnoreCase("claim")) {

				if (args.length == 1) {

					
					if (args[0].equals("list")) {
						player.performCommand("claimslist");
						return false;
					}
					
					else if (args[0].equals("unclaim")) {
						player.performCommand("AbandonClaim");
						return false;
					}
					else if (args[0].equals("unclaimall")) {
						player.performCommand("AbandonAllClaims");
						return false;
					}
					
					else if (args[0].equals("untrustall")) {
						player.performCommand("Untrust all");
						return false;
					}
					
					else if (args[0].equals("trustlist")) {
						player.performCommand("TrustList");
						return false;
					} else msgclaim(player);

				} 

				else if (args.length == 2) {
					
					OfflinePlayer pi = Bukkit.getPlayer(args[1]);
					if(pi == null) { player.sendMessage("§cJoueur invalide ou HorsLigne!"); return false;}
					if(!pi.isOnline()) { player.sendMessage("§cJoueur HorsLigne!"); return false;}
					
					if (args[0].equals("trust1")) {
						player.performCommand("AccessTrust " + args[1]);
						return false;
					}
					else if (args[0].equals("trust2")) {
						player.performCommand("ContainerTrust " + args[1]);
						return false;
					}
					
					else if (args[0].equals("trust3")) {
						player.performCommand("Trust " + args[1]);
						return false;
					}
					
					else if (args[0].equals("untrust")) {
						player.performCommand("UnTrust " + args[1]);
						return false;
					} else msgclaim(player);

				}

				else {
					msgclaim(player);
					return false;
				}

			}
			
    

    //return true;
    } //fin si c joueur
      
      
      
      
      
      
      if (!(sender instanceof Player)) {
      	
      	
      	
    	  if (cmd.getName().equalsIgnoreCase("pubadd"))
    	    { 

    	 if (args.length > 1) {
    	    		
		OfflinePlayer player2 = Bukkit.getOfflinePlayer(args[0]);
		String msg = "";
		for(int i = 1; i<args.length; i++) msg += args[i] + " " ;
    	
    	if (pubeur.containsKey(player2.getName())) {
    		
    		getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + player2.getName() + " Possibilité de PUB * 2");
	        utility.logToFile(player2.getName() + ": " + msg);
    		pubeur.remove(player2.getName());
    		
    	} else {
    		
    	  pubeur.put(player2.getName(), msg);
    	  utility.logToFile(player2.getName() + ": " + msg);
    	  getServer().dispatchCommand(getServer().getConsoleSender(), "tempmute " + player2.getName() + " 7200 Possibilité de PUB");
    	  player2.getPlayer().sendMessage("§bLa prochaine fois si vous tentez de faire de la pub vous serez banni automatiquement, §6Si "
    	  		+ "vous pensez que c'est une erreur merci de contacter le staff sur le forum de craftzone.fr ou sur ts3"); }
    	
    	for(Player pe : Bukkit.getServer().getOnlinePlayers()){
			if(pe.hasPermission("warn.pub"))
				pe.playSound(pe.getLocation(), Sound.ENDERDRAGON_GROWL, 30.0F, 10.0F);
			}
    	
    	
    	    	 
    	     }  else sender.sendMessage("Usage: /pubadd <joueur> <msg>");
    		
    	    	
    	    return false;	
    	    }
    	

        return false;   
        
    } 
      
      

    return false; 
  }
  


public static void RemoveH(){
	
	for (Hologram hologram : HologramsAPI.getHolograms(plugin)) {
		hologram.delete();
    }
	
}


public void msgclaim(Player player) {
	
	player.sendMessage("§e/claim list: §fListe et de vos claims.");
	player.sendMessage("§a/claim unclaim: §fSupprimer un terrain.");
	player.sendMessage("§a/claim unclaimall: §fSupprimer tous vos terrains.");
	player.sendMessage("§b/claim trust1 joueur: §fDonner l'accès aux portes, boutons... à un autre joueur.");
	player.sendMessage("§b/claim trust2 joueur: §fDonner l'accès aux portes, boutons... et coffres à un autre joueur.");
	player.sendMessage("§b/claim trust3 joueur: §fDonner l'accès à un autre joueur pour construire et casser des block.");
	player.sendMessage("§3/claim untrust joueur: §fRetirer tous les accès à ce joueur.");
	player.sendMessage("§3/claim untrust all: §fRetirer touts les accès à tous les joueurs.");
	player.sendMessage("§3/claim trustlist: §fVoir les permissions des joueurs sur votre claim.");
	
}


	public static void changebcaune(){
		 
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.plugin, new Runnable(){
			@SuppressWarnings("deprecation")
			public void run(){
				int xr = ThreadLocalRandom.current().nextInt(0,15);
				Bukkit.getWorld("world").getBlockAt(-6, 73,-45).setTypeIdAndData(95, (byte)xr, false);
			}
		}, 0, 60);

	 
 }
	

	
	@SuppressWarnings("deprecation")
	@EventHandler
	  public void onBlockplace(BlockPlaceEvent event){
		    Player p = event.getPlayer();
		    if(p.isOp()) return;
		    Block block = event.getBlock();
		    Material btype = block.getType();
		    if(btype == Material.COAL_ORE || btype == Material.IRON_ORE || btype == Material.GOLD_ORE || btype == Material.DIAMOND_ORE || btype == Material.EMERALD_ORE || btype == Material.LAPIS_ORE
		    || btype == Material.QUARTZ_ORE || btype == Material.LOG || btype == Material.LOG_2 || btype == Material.GLOWING_REDSTONE_ORE || block.getTypeId()==73) {
		    	p.sendMessage("§cVous n'avez pas la permission de poser ce block!");
		    	event.setCancelled(true);
		    }
		      
		  
	  }
	
	
	  @EventHandler
	  public void spawnEvent(PlayerInteractEvent event) {
	    Player player = event.getPlayer();
	    if ((event.getClickedBlock() != null) && (event.getItem() != null) && 
	      (event.getClickedBlock().getType() == Material.MOB_SPAWNER) && (event.getItem().getType() == Material.MONSTER_EGG)) {
	      event.setCancelled(true);
	      
	      if (player.hasPermission("nospawnermodifier.bypass")) {
	        event.setCancelled(false);
	      }
	    }
	  }


				  
}




