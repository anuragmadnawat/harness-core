/*
 * Copyright 2021 Harness Inc. All rights reserved.
 * Use of this source code is governed by the PolyForm Free Trial 1.0.0 license
 * that can be found in the licenses directory at the root of this repository, also available at
 * https://polyformproject.org/wp-content/uploads/2020/05/PolyForm-Free-Trial-1.0.0.txt.
 */

package io.harness.overviewdashboard.rbac.service;

import static io.harness.annotations.dev.HarnessTeam.PL;

import io.harness.annotations.dev.OwnedBy;
import io.harness.ng.beans.PageResponse;
import io.harness.ng.core.dto.OrganizationResponse;
import io.harness.ng.core.dto.ProjectDTO;

import java.util.List;
import java.util.Map;

@OwnedBy(PL)
public interface DashboardRBACService {
  List<ProjectDTO> listAccessibleProject(String accountIdentifier, String userId);

  PageResponse<OrganizationResponse> listAccessibleOrganizations(String accountIdentifier, List<String> orgIdentifiers);

  Map<String, String> getMapOfOrganizationIdentifierAndOrganizationName(
      String accountIdentifier, List<String> orgIdentifiers);
}
