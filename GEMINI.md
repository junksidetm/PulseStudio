# Pulse Studio — Project Mandates (GEMINI.md)

This file contains foundational mandates for Gemini CLI and autonomous agents when working in this workspace.

## Tech Stack & Architecture
- **Primary Platform:** Native Android development.
- **Framework:** **Jetpack Compose** (Kotlin).
- **Design System:** Rigorously follow **Material 3 Expressive** design language (https://m3.material.io/).
- **Native Mandate:**
  - Prioritize native Android and Jetpack Compose primitives over heavy third-party abstractions.
  - Use `Canvas` for custom dynamic audio and pulse waveform visualizations.
  - Use `StateFlow` and `collectAsStateWithLifecycle()` for reactive, lifecycle-aware state management.
  - Pure offline mock-first architecture without external network or database friction.
  - Guarantee high performance (60–120 FPS) by minimizing recompositions and utilizing derived state.

## Resource & Performance Mandates
- **No Local Builds:** NEVER run `./gradlew assembleDebug`, `./gradlew assembleRelease`, or any command performing full binary builds locally. The host machine is memory-constrained (4 GB RAM).
- **Remote Verification:** All build verifications, APK generations, and release packaging must execute remotely on GitHub Actions runners.
- **Gradle Optimizations:**
  - Parallel execution and caching enabled.
  - Low-memory daemon tuning in `gradle.properties`.

## Release Tagging & Title Naming Mandates
- **Tag Format:** Must strictly follow semantic versioning prefixed with a lowercase `v` (e.g. `v1.0.0`).
- **Release Title Format:** The Release Title MUST EXACTLY match the tag name itself (e.g. `v1.0.0`).
  - **NEVER** prefix or suffix the release title with the application name (e.g. NEVER use `Pulse Studio v1.0.0`).
  - The release title must simply and solely be the tag string: `v<Version>`.

## Multi-Platform Ecosystem & Mirror Mandates (GitHub, GitLab, Codeberg)
- **Primary vs. Mirrors:** GitHub (`junksidetm`) is the **Main** repository; Codeberg (`mrdarksidetm`) and GitLab (`mrdarksidetm`) are official **Mirrors**.
- **Verified Commit Mandate:** Every commit must be cryptographically signed with an SSH key (`id_ed25519_junksidetm` for GitHub, `id_ed25519_signing` for GitLab/Codeberg).
- **Synchronized Deliverables:** Production releases and tags must synchronize across all mirrors.

## Project Tracking & Documentation
- **Version.md Mandate:** `Version.md` is the immutable source of truth for the project's evolution.
  - Strict Append Pattern: NEVER overwrite or edit previous entries. ONLY append new chronological records with full metadata and timestamps.
