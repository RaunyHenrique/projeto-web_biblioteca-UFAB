package com.ufab.biblioteca_ufab.builders;

import org.springframework.test.util.ReflectionTestUtils;

import com.ufab.biblioteca_ufab.models.entidades.MidiaEletronica;

public class MidiaEletronicaBuilder {

    private MidiaEletronica model;

    public MidiaEletronicaBuilder() {
        model = new MidiaEletronica();
    }

    public MidiaEletronicaBuilder id(Long id) {
        ReflectionTestUtils.setField(model, "id", id);
        return this;
    }

    public MidiaEletronica build() {
        return model;
    }
}
