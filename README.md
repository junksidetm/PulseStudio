# ⚡ Pulse Studio

[![GitHub Release](https://img.shields.io/github/v/release/junksidetm/PulseStudio?color=3855E0&label=Release&style=flat-square)](https://github.com/junksidetm/PulseStudio/releases)
[![Build Status](https://img.shields.io/github/actions/workflow/status/junksidetm/PulseStudio/build.yml?branch=main&label=CI%2FCD&style=flat-square)](https://github.com/junksidetm/PulseStudio/actions)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square)](LICENSE)
[![Android](https://img.shields.io/badge/Platform-Android%208.0%2B%20(API%2026%2B)-green.svg?style=flat-square)](https://developer.android.com)

**Pulse Studio** is a pure offline, side-by-side design benchmark Android mockup application. It pits two distinct Material 3 Expressive design philosophies directly against each other in the same binary:

1. 🤖 **The AI Way:** Our vision of Material 3 Expressive — high-chroma cobalt elevations (`#3855E0`), an asymmetrical bento grid, reactive harmonic `Canvas` visualizers, fluid spring micro-motion, and morphing extended FABs.
2. 👥 **The Other's Way:** Real-world community synthesis learning directly from elite Android FOSS projects — 24dp grouped cards, 1dp hairline dividers, M3 switches, segmented controls, service status banners, and persistent mini-player bars.
3. ⚡ **The Dual Wipe Inspector:** An interactive real-time A/B wipe slider allowing you to slide dynamically across both paradigms on a unified canvas!

---

## 🧠 Machine-Readable AI Knowledge Base

Pulse Studio now bundles the complete technical standard for Material 3 Expressive:
- [`MATERIAL_3_EXPRESSIVE_SPECIFICATION.md`](./MATERIAL_3_EXPRESSIVE_SPECIFICATION.md): Authoritative technical standard synthesizing all tokens, contrast ratios, and Compose generation rules.
- [`m3-expressive-knowledge-graph.json`](./m3-expressive-knowledge-graph.json): Structured JSON ontology for LLM context injection and automated verification.

---

## 🪞 Tri-Platform Source Mirrors

Pulse Studio is actively maintained and cryptographically signed across three git hosts:
- **GitHub (Main):** [`junksidetm/PulseStudio`](https://github.com/junksidetm/PulseStudio)
- **GitLab (Mirror):** `mrdarksidetm/PulseStudio`
- **Codeberg (Mirror):** `mrdarksidetm/PulseStudio`

---

## 🎨 Design Philosophy Duel

### 1. The AI Way (Expressive Showcase)
- **Harmonic Sine-Wave Visualizer:** Zero-allocation native Compose `Canvas` calculating harmonic frequencies in real time.
- **Buttons with Options:** Dynamic Split Buttons (`Sync Waveform` with attached dropdown options) and single-choice `SegmentedButton` rows.
- **Filter Chips:** Categorical chip pills (`All`, `Synthwave`, `Ambient`, `Electronic`, `Lo-Fi`) with animated selection bounds.
- **Floating Extended FAB:** Morphing acoustic tuner trigger.
- **Modal Bottom Sheet:** Multi-preset equalizer selector and spatial DSP sliders.

### 2. The Other's Way (Community FOSS Synthesis)
Learned directly from these 6 open-source GitHub repositories:
- **[junksidetm/Gboard-patches](https://github.com/junksidetm/Gboard-patches):** 24dp rounded preference cards, 1dp hairline row dividers, Canvas-rendered anti-aliased `MaterialChevron`, and M3 switches with check icons.
- **[cromaguy/Rhythm](https://github.com/cromaguy/Rhythm):** Bottom mini-player bar with live progress indicator, track info, and playback toggles.
- **[marlboro-advance/mpvEx](https://github.com/marlboro-advance/mpvEx):** Playback speed `SegmentedButton` (`0.5x` to `2.0x`) and audio stream selection dropdowns.
- **[DenserMeerkat/June](https://github.com/DenserMeerkat/June):** Timeline diary cards with mood badges (`Focused`, `Energetic`, `Reflective`) and tag chips.
- **[MorpheApp/microg-RE](https://github.com/MorpheApp/MicroG-RE):** Service status card showing core environment connectivity and health pills.
- **[MorpheApp/morphe-manager](https://github.com/MorpheApp/morphe-manager):** Patch catalog list with version badges (`v4.1.1`), descriptions, and enable/disable switches.

---

## 🛠️ Technical Specifications
- **Target SDK:** 35 (Android 15)
- **Min SDK:** 26 (Android 8.0)
- **UI Framework:** 100% Native Jetpack Compose
- **State Management:** Reactive `StateFlow` and Compose state machines
- **Zero Database / Zero Network:** 100% mock data engine with zero network latency, authentication, or disk database migrations.
