package com.example.FILESTORAGE.util;

import java.util.ArrayList;
import java.util.List;

public interface IoUtils {
    final List<String> whiteBox = new ArrayList<>(List.of(".mp4", ".pdf", ".txt", ".jpg", ".zip", ".jpeg", ".png", ".gif", ".md"));

    static boolean extensionCheck(String extension) {
        return whiteBox.contains(extension);
    }
}
