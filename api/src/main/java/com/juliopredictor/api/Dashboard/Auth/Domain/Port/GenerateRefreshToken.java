package com.juliopredictor.api.Dashboard.Auth.Domain.Port;

import com.juliopredictor.api.Dashboard.Auth.Domain.Model.RefreshToken;

public interface GenerateRefreshToken {
    RefreshToken generateRefreshToken();
}
