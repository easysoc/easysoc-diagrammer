package org.easysoc.plugins.diagrammer;

import com.intellij.openapi.fileTypes.LanguageFileType;
import icons.Icons;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ElktFileType extends LanguageFileType {
  public static final ElktFileType INSTANCE = new ElktFileType();

  protected ElktFileType() {
    super(ElktLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "Elkt";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Elkt language file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "graph";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return Icons.ElktFileType;
  }
}
