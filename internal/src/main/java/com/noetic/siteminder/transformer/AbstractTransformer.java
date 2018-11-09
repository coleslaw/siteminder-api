package com.noetic.siteminder.transformer;

import com.noetic.exception.TransformerException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dineshcaldera on 4/15/16.
 */
@Component
public abstract class AbstractTransformer<O, T> {


    /**
     * Transform {@link O} to {@link T}
     *
     * @param domain the {@link O} to be transformed.
     * @return {@link T}
     */

    public abstract T transformDomainToDTO(O domain) throws TransformerException;

    /**
     * Transform  {@link T} to {@link O}.
     *
     * @param dto the {@link T} to be transformed.
     * @return {@link O}
     */

    public abstract O transformDTOToDomain(T dto) throws TransformerException;


    /**
     * Transform {@link List<O>} to {@link List<T>}
     *
     * @param domains the {@link List<O>} to be transformed.
     * @return {@link List<T>}
     */

    public List<T> transformDomainToDTO(List<O> domains) throws TransformerException {
        List<T> dtos = new ArrayList<T>();

        for (O domain : domains) {
            dtos.add(transformDomainToDTO(domain));
        }

        return dtos;
    }

    /**
     * Transform  {@link List<T>} to {@link List<O>}.
     *
     * @param dtos the {@link List<T>} to be transformed.
     * @return {@link List<O>}
     */

    public List<O> transformDTOToDomain(List<T> dtos) throws TransformerException {
        List<O> domains = new ArrayList<O>();

        for (T dto : dtos) {
            domains.add(transformDTOToDomain(dto));
        }

        return domains;
    }


}
