package acc.br.bean.life.cycle.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Weapon implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware{
    private String name;
    private int health;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Weapon() {
        System.out.println("1. Instantiation: A new item has been created.");
        this.name = "Sword";
        this.health = 100;
    }

    public Weapon(String name) {
        this.name = name;
    }

    public String getWeaponName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. ApplicationContextAware: Setting application context.");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. BeanFactoryAware: Setting bean factory for " + getWeaponName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. Initialization: " + getWeaponName() + " is undergoing intensive training.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: " + getWeaponName() + " is saying goodbye and resting.");
        restAndRecover();
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Executing custom init for " + getWeaponName());
    }

    public void customDestroy() {
        System.out.println("13. Custom Destruction: " + getWeaponName() + " is bidding farewell and performing a final action.");

    }

    private void restAndRecover() {
        System.out.println("12. DisposableBean: " + getWeaponName() + " is resting and recovering energy.");
    }

    @PostConstruct
    public void init() {
        System.out.println("6. @PostConstruct: " + getWeaponName() + " is preparing for action.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy: " + getWeaponName() + " is saying goodbye and preparing to rest.");
    }
}
