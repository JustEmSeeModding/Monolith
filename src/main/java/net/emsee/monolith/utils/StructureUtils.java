package net.emsee.monolith.utils;

import net.emsee.monolith.Monolith;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import javax.annotation.Nullable;
import java.util.Optional;

public final class StructureUtils {
    @Nullable
    public static StructureTemplate getTemplate(final ServerLevel level, final ResourceLocation resourceLocation) {
        if (level == null) {
            return null;
        }
        StructureTemplateManager templateManager = level.getStructureManager();
        Optional<StructureTemplate> template = templateManager.get(resourceLocation);
        if (template.isEmpty()) {
            Monolith.LOGGER.error("Failed to load template for {}", resourceLocation);
        }
        return template.orElse(null);
    }
}
