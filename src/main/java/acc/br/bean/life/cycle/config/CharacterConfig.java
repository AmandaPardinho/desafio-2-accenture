package acc.br.bean.life.cycle.config;

import acc.br.bean.life.cycle.beans.Character;
import acc.br.bean.life.cycle.beans.Item;
import acc.br.bean.life.cycle.beans.Weapon;
import acc.br.bean.life.cycle.processor.MagicBeanPostProcessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
class CharacterConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    @Order(1)
    public Character character() {
        Character character = new Character();
        return character;
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    @Order(2)
    public Weapon sword() {
        return new Weapon();
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    @Order(3)
    public Item potion() {
        return new Item();
    }

    @Bean
    public MagicBeanPostProcessor magicBeanPostProcessor() {
        return new MagicBeanPostProcessor();
    }
}
