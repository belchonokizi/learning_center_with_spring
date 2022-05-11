package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.repository.IModuleRepository;
import com.ilzirabalobanova.epam.learning_center.service.IModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class ModuleService implements IModuleService {
    private final IModuleRepository moduleRepository;

    @Override
    public List<Module> findAllModulesByProgramId(int programId) {
        return moduleRepository.findAllModulesByProgramId(programId);
    }

    @Override
    public boolean addModule(Module module) {
        boolean result = moduleRepository.addModule(module);
        if (!result) {
            log.error("Ошибка в добавлении модуля");
        }
        return result;
    }

    @Override
    public boolean deleteModule(int moduleId) {
        boolean result = moduleRepository.deleteModule(moduleId);
        if (!result) {
            log.error("Ошибка в удалении модуля");
        }
        return result;
    }
    @Override
    public Module findModuleById(int moduleId) {
        return moduleRepository.findModuleById(moduleId);
    }
}
