; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "GSA v2"
#define MyAppVersion "2.0"
#define MyAppPublisher "Lahcen El Amri"
#define MyAppExeName "GSA v2.exe"
#define MyAppAssocName MyAppName + " File"
#define MyAppAssocExt ".myp"
#define MyAppAssocKey StringChange(MyAppAssocName, " ", "") + MyAppAssocExt

[Setup]
; NOTE: The value of AppId uniquely identifies this application. Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{AAA81342-9D7B-4921-9D9D-CD8DB61E5875}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
DefaultDirName={autopf}\{#MyAppName}
ChangesAssociations=yes
DefaultGroupName={#MyAppName}
; Uncomment the following line to run in non administrative install mode (install for current user only.)
;PrivilegesRequired=lowest
OutputDir=C:\Users\J.P.M\Desktop\GSA.v2\Setup
OutputBaseFilename=setup
SetupIconFile=C:\Users\J.P.M\Desktop\GSA.v2\icons\image.ico
Compression=lzma
SolidCompression=yes
WizardStyle=modern

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "french"; MessagesFile: "compiler:Languages\French.isl"

[Files]
Source: "C:\Users\J.P.M\Desktop\GSA.v2\{#MyAppExeName}"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\J.P.M\Desktop\GSA.v2\bin\*"; DestDir: "{app}\bin\"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\J.P.M\Desktop\GSA.v2\Detectors\*"; DestDir: "{app}\Detectors\"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\J.P.M\Desktop\GSA.v2\Doc\*"; DestDir: "{app}\Doc\"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\J.P.M\Desktop\GSA.v2\example\*"; DestDir: "{app}\example\"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\J.P.M\Desktop\GSA.v2\icons\*"; DestDir: "{app}\icons\"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\J.P.M\Desktop\GSA.v2\results\*"; DestDir: "{app}\results\"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\J.P.M\Desktop\GSA.v2\Setup\*"; DestDir: "{app}\Setup\"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\J.P.M\Desktop\GSA.v2\src\*"; DestDir: "{app}\src\"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Registry]
Root: HKA; Subkey: "Software\Classes\{#MyAppAssocExt}\OpenWithProgids"; ValueType: string; ValueName: "{#MyAppAssocKey}"; ValueData: ""; Flags: uninsdeletevalue
Root: HKA; Subkey: "Software\Classes\{#MyAppAssocKey}"; ValueType: string; ValueName: ""; ValueData: "{#MyAppAssocName}"; Flags: uninsdeletekey
Root: HKA; Subkey: "Software\Classes\{#MyAppAssocKey}\DefaultIcon"; ValueType: string; ValueName: ""; ValueData: "{app}\{#MyAppExeName},0"
Root: HKA; Subkey: "Software\Classes\{#MyAppAssocKey}\shell\open\command"; ValueType: string; ValueName: ""; ValueData: """{app}\{#MyAppExeName}"" ""%1"""
Root: HKA; Subkey: "Software\Classes\Applications\{#MyAppExeName}\SupportedTypes"; ValueType: string; ValueName: ".myp"; ValueData: ""

[Icons]
Name: "{group}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{group}\{cm:UninstallProgram,{#MyAppName}}"; Filename: "{uninstallexe}"

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent
