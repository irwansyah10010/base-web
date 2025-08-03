package io.irwansyahdev96.backoffice.business;

import io.irwansyahdev96.backoffice.base.controller.pattern.SetUp;

public interface Business{
    Business addTemplate(String parameterName, String filename);
    Business addTemplates(String relativePath);
    Business addCollection(String parameterName, Object...colections);
    Business addData(String parameterName, Object data);

    SetUp endBusiness();
}
