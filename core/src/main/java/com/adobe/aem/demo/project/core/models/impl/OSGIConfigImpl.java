package com.adobe.aem.demo.project.core.models.impl;

import com.adobe.aem.demo.project.core.models.OSGIConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;


@Component(
        service = {OSGIConfig.class}
)
@Designate(ocd = OSGIConfigImpl.Config.class)
public class OSGIConfigImpl implements OSGIConfig {

    @ObjectClassDefinition(
            name = "Custom OSGI Configurations",
            description = "OSGi Service providing information about WKND Adventures activities"
    )
    @interface Config {
        @AttributeDefinition(
                name = "WKND Activities",
                description = "Human-friendly list of activity names"
        )
        String[] activities() default { "Hiking", "Jogging", "Walking" };

        @AttributeDefinition(
                name = "Random Activity Seed",
                description = "Seed used to randomize activity selection"
        )
        int random_seed() default 10;

    }

    private String[] activities;

    private Random random;

    /**
     * @return the name of a random WKND adventure activity
     */
    @Override
    public String getRandomActivity() {
        int randomIndex = random.nextInt(activities.length);
        return activities[randomIndex];
    }

    @Activate
    protected void activate(Config config) {

        this.activities = config.activities();

        final int randomSeed = config.random_seed();

        this.random = new Random(randomSeed);

        _log.info("Activated ActivitiesImpl with activities [ {} ]", String.join(", ", this.activities));
    }

    @Deactivate
    protected void deactivate() {
        _log.info("ActivitiesImpl has been deactivated!");
    }
    private static final Logger _log = LoggerFactory.getLogger(OSGIConfigImpl.class);

}
