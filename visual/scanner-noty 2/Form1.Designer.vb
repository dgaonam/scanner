<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form reemplaza a Dispose para limpiar la lista de componentes.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Requerido por el Diseñador de Windows Forms
    Private components As System.ComponentModel.IContainer

    'NOTA: el Diseñador de Windows Forms necesita el siguiente procedimiento
    'Se puede modificar usando el Diseñador de Windows Forms.  
    'No lo modifique con el editor de código.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1))
        Me.Notificacion = New System.Windows.Forms.NotifyIcon(Me.components)
        Me.MenuApp = New System.Windows.Forms.ContextMenuStrip(Me.components)
        Me.IniciarToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.DetenerToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.SalirToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.AcercaDeToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.Button = New System.Windows.Forms.Button()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.MenuApp.SuspendLayout()
        Me.SuspendLayout()
        '
        'Notificacion
        '
        Me.Notificacion.ContextMenuStrip = Me.MenuApp
        Me.Notificacion.Icon = CType(resources.GetObject("Notificacion.Icon"), System.Drawing.Icon)
        Me.Notificacion.Text = "Digitalizacion"
        Me.Notificacion.Visible = True
        '
        'MenuApp
        '
        Me.MenuApp.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.IniciarToolStripMenuItem, Me.DetenerToolStripMenuItem, Me.SalirToolStripMenuItem, Me.AcercaDeToolStripMenuItem})
        Me.MenuApp.Name = "ContextMenuStrip1"
        Me.MenuApp.Size = New System.Drawing.Size(136, 92)
        '
        'IniciarToolStripMenuItem
        '
        Me.IniciarToolStripMenuItem.Name = "IniciarToolStripMenuItem"
        Me.IniciarToolStripMenuItem.Size = New System.Drawing.Size(135, 22)
        Me.IniciarToolStripMenuItem.Text = "Iniciar"
        '
        'DetenerToolStripMenuItem
        '
        Me.DetenerToolStripMenuItem.Name = "DetenerToolStripMenuItem"
        Me.DetenerToolStripMenuItem.Size = New System.Drawing.Size(135, 22)
        Me.DetenerToolStripMenuItem.Text = "Detener"
        '
        'SalirToolStripMenuItem
        '
        Me.SalirToolStripMenuItem.Name = "SalirToolStripMenuItem"
        Me.SalirToolStripMenuItem.Size = New System.Drawing.Size(135, 22)
        Me.SalirToolStripMenuItem.Text = "Salir"
        '
        'AcercaDeToolStripMenuItem
        '
        Me.AcercaDeToolStripMenuItem.Name = "AcercaDeToolStripMenuItem"
        Me.AcercaDeToolStripMenuItem.Size = New System.Drawing.Size(135, 22)
        Me.AcercaDeToolStripMenuItem.Text = "Acerca de..."
        '
        'Button
        '
        Me.Button.BackColor = System.Drawing.SystemColors.Window
        Me.Button.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button.Location = New System.Drawing.Point(197, 125)
        Me.Button.Name = "Button"
        Me.Button.Size = New System.Drawing.Size(214, 41)
        Me.Button.TabIndex = 1
        Me.Button.Text = "Salir"
        Me.Button.UseVisualStyleBackColor = False
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Arial Narrow", 24.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(190, 0)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(174, 37)
        Me.Label1.TabIndex = 3
        Me.Label1.Text = "Digitalizador"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(121, 94)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(42, 13)
        Me.Label2.TabIndex = 4
        Me.Label2.Text = "Version"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label3.Location = New System.Drawing.Point(163, 94)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(25, 13)
        Me.Label3.TabIndex = 5
        Me.Label3.Text = "1.0"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(70, 51)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(415, 13)
        Me.Label4.TabIndex = 6
        Me.Label4.Text = "Software para digitalizar los documentos del juzgado y subir a la plataforma del " &
    "juzgado"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(123, 64)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(289, 13)
        Me.Label5.TabIndex = 7
        Me.Label5.Text = "Derechos reservados al poder judicial del Estado de México"
        '
        'Form1
        '
        Me.AccessibleRole = System.Windows.Forms.AccessibleRole.None
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.CausesValidation = False
        Me.ClientSize = New System.Drawing.Size(581, 178)
        Me.ControlBox = False
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.Button)
        Me.ImeMode = System.Windows.Forms.ImeMode.Off
        Me.MaximizeBox = False
        Me.MinimizeBox = False
        Me.Name = "Form1"
        Me.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Acerca de Digitalizador"
        Me.MenuApp.ResumeLayout(False)
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Notificacion As NotifyIcon
    Friend WithEvents MenuApp As ContextMenuStrip
    Friend WithEvents IniciarToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents DetenerToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents SalirToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents AcercaDeToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents Button As Button
    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents Label4 As Label
    Friend WithEvents Label5 As Label
End Class
