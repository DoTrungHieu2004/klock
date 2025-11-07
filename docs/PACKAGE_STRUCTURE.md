# Klock Package Structure Guide

## 📁 Current Package Hierarchy

```
app/src/main/java/com/yourname/klock/
├── ui/ # User Interface Layer
│ ├── theme/ # Design System & Theming
│ │ ├── Color.kt # Color palettes (light/dark)
│ │ ├── Type.kt # Typography system
│ │ ├── Shape.kt # Shape definitions
│ │ ├── Theme.kt # Main theme composable
│ │ ├── ThemePreview.kt # Theme testing & previews
│ │ └── state/ # Theme State Management
│ │ └── ThemeState.kt # Theme mode state
│ ├── components/ # Reusable UI Components
│ │ └── ThemeSwitcher.kt # Theme control components
│ └── screens/ # App Screens & Layouts
│ └── MainActivity.kt # Main app screen
├── engine/ # Custom Clock Engines (Future)
├── animation/ # Animation System (Future)
└── time/ # Time Management (Future)
```

## 🎯 Package Design Rationale

### 1. UI-Centric Organization
- **All visual components** are grouped under `ui/` package
- **Clear separation** between UI and business logic
- **Easy navigation** for UI developers

### 2. Theme System Structure
- `ui/theme/` - Design tokens and theming infrastructure
- `ui/theme/state/` - Theme-specific state management
- `ui/components/` - Theme-aware UI components

### 3. State Management Strategy
- **Theme state**: UI-specific, lives in `ui/theme/state/`
- **Future clock state**: Will live in `engine/` or `time/` packages
- **Clear boundaries** between different state types

## 🔄 Import Examples

### Theme System Usage

```
// Theme provider and state
import com.yourname.klock.ui.theme.KlockTheme
import com.yourname.klock.ui.theme.state.ThemeState

// UI components
import com.yourname.klock.ui.components.ThemeSwitcher

// Design tokens
import com.yourname.klock.ui.theme.ClockColors
```

### Component Implementation

```kotlin
@Composable
fun SettingsScreen() {
    val themeState = MaterialTheme.themeState
    
    Column {
        ThemeSwitcher()  // From ui.components
        // ... other settings
    }
}
```

## 🚀 Future Package Expansion

### Planned Structure

```
ui/
├── components/
│   ├── clock/          # Clock-specific components
│   │   ├── ClockFace.kt
│   │   ├── ClockHand.kt
│   │   └── ClockMarkers.kt
│   └── common/         # Generic UI components
│       ├── buttons/
│       └── cards/
└── screens/
    ├── MainScreen.kt
    ├── SettingsScreen.kt
    └── AboutScreen.kt

engine/
├── TimeEngine.kt       # Core time management
├── AnimationEngine.kt  # Custom animation system
└── state/              # Engine state management
    └── TimeState.kt

time/
├── models/             # Time data models
├── sources/            # Time data sources
└── interpolators/      # Time interpolation
```

## 📝 Best Practices

1. Package naming
- Use singular names (`theme` not `themes`)
- Group related functionality
- Avoid deep nesting (max 3-4 levels)

2. File organization
- Co-locate related files
- Use subpackages for clear separation
- Follow feature-based grouping

3. Import management
- Use clear, intuitive package names
- Avoid wildcard imports
- Group imports logically