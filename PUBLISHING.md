# Publishing Better Block Sounds Fork

Publishing is controlled from the default `1.21.1` branch. Normal commits and existing build workflows never upload files to CurseForge or Modrinth.

## One-time setup

Create these GitHub **repository secrets** in Settings -> Secrets and variables -> Actions:

- `CURSEFORGE_TOKEN` — your CurseForge upload token
- `MODRINTH_TOKEN` — your Modrinth personal access token with version-write access

Projects are already configured: CurseForge `1232054`, Modrinth `ZnMA9t3T`. Never commit tokens or put them in JSON release requests.

## Supported branches

| Minecraft | Fabric | NeoForge | Java |
| --- | --- | --- | --- |
| 1.21.1 | `1.21.1-fabric` | `1.21.1` | 21 |
| 26.1 – 26.1.2 | `26.1.2-fabric` | `26.1.2-neo` | 25 |
| 26.2 | `26.2-fabric` | `26.2-neo` | 25 |
| 26.3 | `26.3-fabric` | `26.3-neo` | 25 |

`1.20.1` is intentionally excluded.

## Changelog

Each supported branch has its own `CHANGELOG.md`. Replace the `RELEASE_NOTES_REQUIRED` placeholder with real Markdown release notes before submitting a release request. The workflow rejects placeholder release notes. The same file becomes the changelog on both platforms.

## Build-only verification

Open GitHub Actions -> **Publish BBSF (approved release requests)** -> **Run workflow**, and choose a `validate_branch`. Choosing a branch builds it **without publishing**. Choosing `none` only checks previously approved release requests.

## Immediate or scheduled publication

Publication requires adding a JSON request to `.github/release-requests/pending/` **on the default branch**. Only create this request when the owner explicitly authorizes publication. Example:

```json
{
  "authorization": "PUBLISH_APPROVED",
  "branch": "26.3-fabric",
  "publish_at_utc": "2026-11-07T19:45:00Z",
  "release_type": "release"
}
```

Choose a unique filename, e.g. `2026-11-07-26.3-fabric.json`. Valid `release_type` values are `release`, `beta`, and `alpha`. Create one request per branch; requests for different branches can run together.

A request with a due time in the past is picked up by the push-triggered workflow. A future request is picked up by the scheduler, checking at minutes **07, 22, 37, and 52 UTC** of each hour. Convert local dates/times to **UTC** when adding requests. For example, Kyiv time varies between UTC+2 and UTC+3 depending on daylight saving time.

Before any upload, the workflow checks that both secrets exist and moves due requests to `.github/release-requests/claimed/` in a dedicated commit. Claimed requests are never published again automatically. If the build or a platform upload fails, inspect both platform projects before explicitly authorizing a new request; the upload may have partially succeeded.

GitHub scheduled runs are best effort and can start later than the requested time. Do not rely on minute-exact publication. For a stricter launch time, trigger a manually approved request close to the intended time.

## How to request releases through ChatGPT

Ask: *Publish BBSF 2.0.0 for 26.3 Fabric and NeoForge now.* Or: *Schedule BBSF for 1.21.1 and 26.2 for Saturday at 21:30 Kyiv time.* ChatGPT should first verify the branches, final Markdown changelog, and secret readiness, and **only after that explicit instruction** add the corresponding approved request files. Writing a request file starts publication when due; never create one while merely discussing plans.

Publishing uses `Kir-Antipov/mc-publish@v3.3` and derives the runtime JAR and version from each branch. The existing CI build workflows remain independent.
