package com.tontine.app.service;

import com.tontine.app.domain.ChiTietHui;
import com.tontine.app.repository.ChiTietHuiRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ChiTietHui}.
 */
@Service
@Transactional
public class ChiTietHuiService {

    private final Logger log = LoggerFactory.getLogger(ChiTietHuiService.class);

    private final ChiTietHuiRepository chiTietHuiRepository;

    public ChiTietHuiService(ChiTietHuiRepository chiTietHuiRepository) {
        this.chiTietHuiRepository = chiTietHuiRepository;
    }

    /**
     * Save a chiTietHui.
     *
     * @param chiTietHui the entity to save.
     * @return the persisted entity.
     */
    public ChiTietHui save(ChiTietHui chiTietHui) {
        log.debug("Request to save ChiTietHui : {}", chiTietHui);
        return chiTietHuiRepository.save(chiTietHui);
    }

    /**
     * Update a chiTietHui.
     *
     * @param chiTietHui the entity to save.
     * @return the persisted entity.
     */
    public ChiTietHui update(ChiTietHui chiTietHui) {
        log.debug("Request to update ChiTietHui : {}", chiTietHui);
        return chiTietHuiRepository.save(chiTietHui);
    }

    /**
     * Partially update a chiTietHui.
     *
     * @param chiTietHui the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ChiTietHui> partialUpdate(ChiTietHui chiTietHui) {
        log.debug("Request to partially update ChiTietHui : {}", chiTietHui);

        return chiTietHuiRepository
            .findById(chiTietHui.getId())
            .map(existingChiTietHui -> {
                return existingChiTietHui;
            })
            .map(chiTietHuiRepository::save);
    }

    /**
     * Get all the chiTietHuis.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ChiTietHui> findAll(Pageable pageable) {
        log.debug("Request to get all ChiTietHuis");
        return chiTietHuiRepository.findAll(pageable);
    }

    /**
     * Get one chiTietHui by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ChiTietHui> findOne(Long id) {
        log.debug("Request to get ChiTietHui : {}", id);
        return chiTietHuiRepository.findById(id);
    }

    /**
     * Delete the chiTietHui by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ChiTietHui : {}", id);
        chiTietHuiRepository.deleteById(id);
    }
}