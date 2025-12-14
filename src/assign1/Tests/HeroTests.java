package assign1.Tests;

import assign1.*;
import org.junit.Test;

public class HeroTests
{
 @Test
 public void TestElf()
 {

  Elf obLeafLover = new Elf("Doe", HeroType.Mage);
  Human obHuman = new Human("John", HeroType.Fighter);
  Dwarf obMiner = new Dwarf("Miner", HeroType.Thief);
  Hobbit obHobbit = new Hobbit("Jimmy", HeroType.Mage);
  Hero[] obHeroes = {obLeafLover,obHuman, obMiner, obHobbit};

  for (Hero obHero : obHeroes)
  {
   System.out.println(obHero);
  }

 }
 @Test
 public void TestAttack()
 {
  Elf obLeafLover = new Elf("Doe", HeroType.Mage);
  Human obHuman = new Human("John", HeroType.Fighter);
  System.out.println(obLeafLover);
  obLeafLover.defend(obHuman);
  System.out.println(obLeafLover);


 }
 @Test
 public void createHero() {

  GameTest[] obHeroes = GameTest.createHero();
  for (GameTest obGame : obHeroes) {
   System.out.println(obGame);
  }

 }

 @Test
 public void battleRound() {
  Hero obHero1 = new Dwarf("Dwarf", HeroType.Mage);
  Hero obHero2 = new Elf("Elf", HeroType.Thief);

  System.out.println(GameTest.battleRound(obHero1,obHero2));
 }



}
